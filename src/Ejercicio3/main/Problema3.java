package Ejercicio3.main;

import Ejercicio3.model.Dupla;
import Ejercicio3.model.Jugador;
import Ejercicio3.model.Tablero;
import Otros.Problema;

import java.util.ArrayList;

/**
 * Created by santicamacho on 07/05/14.
 */
public class Problema3 extends Problema {

    private Dupla inicio;
    private Dupla fin;
    private Tablero tablero;

    public Problema3(String input) {
        super(input);
    }

    @Override
    protected void interpretarInstancia() {
        String[] lineas = input.split("\n");
        String[] primerLinea = lineas[0].split(" ");

        int n = Integer.valueOf(primerLinea[0]);
        int k = Integer.valueOf(primerLinea[5]);
        //asigno casillero de inicio
        this.inicio = new Dupla(Integer.valueOf(primerLinea[1]),Integer.valueOf(primerLinea[2]));
        //asigno casillero de fin
        this.fin = new Dupla(Integer.valueOf(primerLinea[3]),Integer.valueOf(primerLinea[4]));

        //asigno la matriz para el tablero.
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] fila = lineas[i+1].split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.valueOf(fila[j]);
            }
        }

        this.tablero = new Tablero(n,k,matrix);

    }

    public String resolver(){
        Jugador jug = new Jugador(this.inicio,this.fin,this.tablero);
        jug.resolver();

        String output = "Saltos: "+ jug.saltos() + "\n";

        return output;
    }
}