package Ejercicio2.model;

import java.text.DecimalFormat;

/**
 * Created by Tomi on 22-Apr-14.
 */
public class DistanciasEntrePueblos {
    private Pueblo[] pueblos;
    private double[][] distancias;

    public DistanciasEntrePueblos(Pueblo[] pueblos) {
        this.pueblos = pueblos;
        distancias = new double[pueblos.length -1][];
        for(int i = 0; i < distancias.length; i++){
            distancias[i] = new double[i + 1];
        }

        calcularDistancias();

//        imprimirMatris();
    }

    private void imprimirMatris() {
        DecimalFormat twoDecimals = new DecimalFormat("0.00");
        for(int i = 0; i < distancias.length; i++){
            for(int j = 0; j< distancias[i].length; j++){
                System.out.print(twoDecimals.format(distancias[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    public double getDistancia(Pueblo puebloPartida, Pueblo puebloDestino) {
        if(puebloPartida.getId() == puebloDestino.getId()) return 0;
        if(puebloPartida.getId() < puebloDestino.getId()) return getDistancia(puebloDestino, puebloPartida);
        return distancias[puebloPartida.getId() -1 ][puebloDestino.getId()];
    }

    private void calcularDistancias() {
        for(Pueblo puebloPartida : pueblos){
            for(Pueblo puebloDestino : pueblos){
                if(puebloDestino.getId() == puebloPartida.getId()) continue;
                if(getDistancia(puebloPartida, puebloDestino) != 0) continue;

                double distancia = calcularDistancia(puebloPartida, puebloDestino);

                if(puebloPartida.getId() > puebloDestino.getId())
                    distancias[puebloPartida.getId() -1][puebloPartida.getId()] = distancia;
                else
                    distancias[puebloDestino.getId() -1][puebloPartida.getId()] = distancia;
            }
        }
    }

    private double calcularDistancia(Pueblo puebloPartida, Pueblo puebloDestino) {
        double x = Math.pow(puebloDestino.getX() - puebloPartida.getX(), 2);
        double y = Math.pow(puebloDestino.getY() - puebloPartida.getY(), 2);
        return Math.sqrt(x + y);
    }
}
