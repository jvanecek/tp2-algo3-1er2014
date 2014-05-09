package Ejercicio3.model;

/**
 * Created by santicamacho on 05/05/14.
 */
public class Tripla{
    private int a;
    private int b;
    private int c;

    public Tripla( int a, int b, int c ) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getFirst(){
        return this.a;
    }
    public int getSecond(){
        return this.b;
    }
    public int getThird(){
        return this.c;
    }

    public void setFirst(int a){
        this.a = a;
    }
    public void setSecond(int b){
        this.b = b;
    }
    public void setThird(int c)
    {
        this.c = c;
    }

    public Dupla triplaToDupla()
    {
        return new Dupla(this.b, this.c);
    }

    public boolean equals(Tripla x)
    {
        boolean res = false;
        int b = x.getSecond();
        int c = x.getThird();

        if ((b == this.b) && (c == this.c))
        {
            res = true;
        }
        return  res;
    }
}