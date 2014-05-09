package Ejercicio3.model;

/**
 * Created by santicamacho on 05/05/14.
 */
public class Dupla {
    private int a;
    private int b;

    public Dupla( int a, int b ) {
        this.a = a;
        this.b = b;
    }

    public int getFirst(){
        return this.a;
    }
    public int getSecond(){
        return this.b;
    }

    public void setFirst(int a){
        this.a = a;
    }
    public void setSecond(int b){
        this.b = b;
    }

    public Tripla duplaToTripla(int k)
    {
        return new Tripla(k,this.a, this.b);
    }

    public boolean equals(Dupla x)
    {
        boolean res = false;
        int a = x.getFirst();
        int b = x.getSecond();

        if ((b == this.b) && (a == this.a))
        {
            res = true;
        }
        return  res;
    }
}
