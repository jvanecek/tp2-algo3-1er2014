package Ejercicio1.model;

/**
 * Created by juan on 21/04/14.
 */
public class Robanumeros {
	private class Jugada {
		String desde;
		int cartas;
	}
	
	private int[] cartas; /**< Cartas del juego. */
	private int[][] cache; /**< Cache de resultados. */
	private Jugada[][] jugadas; /**< Jugada elegida en cada paso. */

	private int min( int a, int b ) { return a < b ? a : b; }
	private int sum( int i, int j ) { int res = 0; for(int k = i; k <= j; k++) res += cartas[k]; return res; }
	
	public Robanumeros( int[] cartas ){
		int n = cartas.length;
		this.cartas = cartas;
		cache = new int[n][n];
		jugadas = new Jugada[n][n];
		for ( int i = 0; i < n; i++ ) {
			for ( int j = 0; j < n; j++ )
				jugadas[i][j] = new Jugada();
		}
	}

	public void calcularSolucion() {
		int n = cartas.length;
		for ( int i = 0; i < n; i++ ) {
			cache[i][i] = cartas[i];
			jugadas[i][i].desde = "izq";
			jugadas[i][i].cartas = 1;
		}

		for ( int columna = 1; columna < n; columna++ ) {
			for ( int diagonal = 0; diagonal < n - columna; diagonal++ ) {
				int i = diagonal;
				int j = columna + diagonal;
				int min_ij = Integer.MAX_VALUE;
				int puntos = 0;
				int x = i, y = j;
				for ( int k = i; k <= j; k++ ) {
					int a = 0, b = 0;
					puntos += cartas[k];
					if ( k + 1 <= j ) a = cache[k + 1][j];
					if ( k - 1 >= i ) b = cache[i][k - 1];
					if ( min_ij < a && min_ij < b ) continue;
					if ( a < b ) {
						jugadas[i][j].desde = "izq";
						jugadas[i][j].cartas = k - i + 1;
						min_ij = a;
					} else {
						jugadas[i][j].desde = "der";
						jugadas[i][j].cartas = j - k + 1;
						min_ij = b;
					}
				}
				cache[i][j] = puntos - min_ij;
			}
		}
	}
	
	public String obtenerSolucion() {
		StringBuilder res = new StringBuilder();
		
		int i = 0, j = cartas.length - 1;
		int turnos = 0;
		
		int puntaje1, puntaje2;
		puntaje1 = cache[i][j];
		puntaje2 = sum( i, j ) - puntaje1;
		
		while ( i <= j ) {
			turnos++;
			
			res.append( jugadas[i][j].desde + " "  + String.valueOf( jugadas[i][j].cartas ) + "\n" );
			if ( jugadas[i][j].desde.equals( "izq" ) )
				i += jugadas[i][j].cartas;
			else
				j -= jugadas[i][j].cartas;
		}
		
		return String.valueOf( turnos )  + " " + String.valueOf( puntaje1 ) + " " +
				String.valueOf( puntaje2 ) + "\n" + res.toString();
	}
}

