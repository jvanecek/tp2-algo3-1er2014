package Ejercicio3.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by santicamacho on 05/05/14.
 */
public class Tablero {
    private int[][][] superMatrix; //array de matrices, la posicion en el primer arreglo son los K usados.
    private int n;
    private int poderes;

    public Tablero(int n, int k, int[][] Matrix)
    {
        this.n = n;
        this.poderes = k;

        superMatrix = new int[k+1][][];
        for(int i = 0; i <= k; i++)
        {
            superMatrix[i] = Matrix;
        }
    }

    public List<Tripla> vecinos (int k, int x, int y)
    {
        int valor = this.superMatrix[k][x-1][y-1]; //x-1 y-1

        List<Tripla> vs = new ArrayList<Tripla>();
        List<Tripla> horizontales = valoresHorizontales(k,x,y,valor);
        List<Tripla> verticales = valoresVerticales(k,x,y,valor);

        vs.addAll(horizontales);
        vs.addAll(verticales);
        return vs;
    }

    private List<Tripla> valoresHorizontales (int k, int x, int y, int valor)
    {
        List<Tripla> vs = new ArrayList<Tripla>();
        Tripla v = new Tripla(k,x,y);
        //valores horizontales
        for (int i = 0; i <= valor; i++)
        {
            if ((x+i) <= this.n)
            {
                v.setSecond((x+i));
                vs.add(v);
            }
            if ((x-i) > 0)
            {
                v.setSecond((x-i));
                vs.add(v);
            }
        }
        //valores horizontales con poder
        if((this.poderes-k)>0) //si quedan poderes entonces...
        {
            for (int i = 1; i <= (this.poderes - k); i++)
            {
                if ((x + valor + i) <= this.n)
                {
                    v.setFirst(k + i);
                    v.setSecond(x + valor + i);
                    vs.add(v);
                }
                if ((x - valor - i) > 0)
                {
                    v.setFirst(k + i);
                    v.setSecond(x - valor - i);
                    vs.add(v);
                }
            }
        }
        return vs;
    }

    private List<Tripla> valoresVerticales (int k, int x, int y, int valor)
    {
        List<Tripla> vs = new ArrayList<Tripla>();
        Tripla v = new Tripla(k,x,y);
        //valores verticales
        for (int i = 0; i <= valor; i++)
        {
            if ((y+i) <= this.n)
            {
                v.setThird(y+i);
                vs.add(v);
            }
            if ((y-i) > 0)
            {
                v.setThird(y-i);
                vs.add(v);
            }
        }
        //valores verticales con poder
        if((this.poderes-k)>0) //si quedan poderes entonces...
        {
            for (int i = 1; i <= (this.poderes - k); i++)
            {
                if ((y + valor + i) <= this.n)
                {
                    v.setFirst((k + i));
                    v.setThird(y + valor + i);
                    vs.add(v);
                }
                if ((y - valor - i) > 0)
                {
                    v.setFirst((k + i));
                    v.setThird(y - valor - i);
                    vs.add(v);
                }
            }
        }
        return vs;
    }
}
