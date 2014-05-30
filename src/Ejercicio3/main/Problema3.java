package Ejercicio3.main;

import Ejercicio3.model.Tablero;
import Ejercicio3.model.Nodo;
import Otros.Problema;
import Otros.Utils;

/**
 * Created by santicamacho on 07/05/14.
 */
public class Problema3 extends Problema {

    private Tablero tablero;

    public Problema3(String input) {
        super(input);
    }

    @Override
    protected void interpretarInstancia() {
        String[] lineas = input.split("\n");

        int[] params = Utils.parseArrayI(lineas[0]);
		int n = params[0];

        int[][] potencias = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] potencia = Utils.parseArrayI(lineas[i+1]);
            for (int j = 0; j < n; j++) {
                potencias[i][j] = potencia[j];
            }
        }

        tablero = new Tablero(n,params[5], params[1], params[2], params[3], params[4], potencias);

    }

    public String resolver() {
		int saltos = tablero.resolver();

        String output = saltos + "\n";

		for( Nodo v : tablero.getSolucion() )
			output += v.getFila() + " " + v.getCol() + " " + v.getPoderesUsados() + "\n";

        return output;
    }
}