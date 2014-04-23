package Ejercicio2.model;

/**
 * Created by Tomi on 23-Apr-14.
 */
public class Camino{

    private Pueblo[] pueblosInvolucrados = new Pueblo[2];
    private double distancia;

    public Camino(Pueblo unPueblo, Pueblo otroPueblo, double distancia){
        this.pueblosInvolucrados[0] = unPueblo;
        this.pueblosInvolucrados[1] = otroPueblo;
        this.distancia = distancia;
    }

    public Pueblo[] getPueblosInvolucrados() {
        return pueblosInvolucrados;
    }

    public double getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return pueblosInvolucrados[0] + " y " + pueblosInvolucrados[1] + " con distancia " + distancia;
    }
}
