package Ejercicio1.model;

/**
 * Created by juan on 21/04/14.
 */
public class Robanumeros {
	private int[] cartas; /**< Cartas del juego. */
	private int puntos; /**< Puntaje del jugador 1 del juego finalizado. */
	private int[][] cache;

	private int min( int a, int b ) { return a < b ? a : b; }
	private int min( int a, int b, int c ) { return min( a, min( b, c ) ); }
	private int sum( int i, int j ) { int res = 0; for(int k = i; k <= j; k++) res += cartas[k]; return res; }

	public Robanumeros( int[] cartas ){
		this.cartas = cartas;
		cache = new int[cartas.length][cartas.length];
	}

	private void construir() {
		int n = cartas.length;
		for ( int i = 0; i < n; i++ )
			cache[i][i] = cartas[i];

		for ( int columna = 1; columna < n; columna++ ) {
			for ( int diagonal = 0; diagonal < n - columna; diagonal++ ) {
				int i = diagonal;
				int j = columna + diagonal;
				int min_ij = Integer.MAX_VALUE;
				int puntos = 0;
				for ( int k = i; k <= j; k++ ) {
					int a = 0, b = 0;
					puntos += cartas[k];
					if ( k + 1 <= j ) a = cache[k + 1][j];
					if ( k - 1 >= i ) b = cache[i][k - 1];
					min_ij = min( min_ij, a, b );
				}
				cache[i][j] = puntos - min_ij;
			}
		}
	}

	public void calcularOptimoPuntaje() {
		construir();
		puntos = cache[0][cartas.length - 1];
	}

	public int getOptimoPuntaje(){
		return puntos;
	}

}
