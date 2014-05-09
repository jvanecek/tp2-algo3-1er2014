package Ejercicio3.model;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by santicamacho on 05/05/14.
 */
public class Jugador {
    private HashMap<Dupla, Integer> niveles; //diccionario que contiene a cuantos saltos o nivel esta tal casillero.
    private HashMap<Dupla, Integer> poderesUsadosHastaAqui; //diccionario que contiene a cuantos poderes se usaron hasta el casillero.
    private HashMap<Tripla, Tripla> anterior; //diccionario que dado un casillero devuelve cual es el anterior en su camino minimo desde el inicio.
    private Dupla inicio;
    private Dupla fin;
    private Tablero tablero;

    public Jugador(Dupla inicio, Dupla fin, Tablero tablero)
    {
        this.inicio = inicio;
        this.fin = fin;
        this.tablero = tablero;
        this.niveles = new HashMap<Dupla, Integer>();
        this.poderesUsadosHastaAqui = new HashMap<Dupla, Integer>();
        this.anterior = new HashMap<Tripla, Tripla>();
    }

    public void resolver() //USA EL ALGORITMO DE BFS
    {
        this.niveles.put(this.inicio,0);
        Tripla inicioT = this.inicio.duplaToTripla(0);
        this.anterior.put(inicioT, null);
        int nivel = 1;
        ArrayList<Tripla> frontera = new ArrayList<Tripla>();
        frontera.add(inicioT);
        while(!frontera.isEmpty())
        {
            ArrayList<Tripla> siguiente = new ArrayList<Tripla>();
            for(Tripla t : frontera)
            {
                for (Tripla v : tablero.vecinos(t.getFirst(),t.getSecond(),t.getThird()))
                {
                    Dupla v2 = v.triplaToDupla();
                    if(!this.niveles.containsKey(v2))
                    {
                        this.niveles.put(v2,nivel);
                        this.anterior.put(v,t);
                        siguiente.add(v);
                    }
                }
            }
            frontera.clear();
            frontera.addAll(siguiente);
            nivel = nivel+1;
        }
    }

    public int saltos()
    {
        return this.niveles.get(this.fin);
    }

    //FALTA EL METODO DE CONSTRUCCION DEL CAMINO Y LOS SALTOS.

}
