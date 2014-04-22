package Ejercicio1.model;

/**
 * Created by juan on 21/04/14.
 */
public class Robanumeros {
	private int[] cartas; /**< Cartas del juego. */
	private int puntos; /**< Puntaje del jugador 1 del juego finalizado. */

	private int min( int a, int b ) { return a < b ? a : b; }
	private int sum( int i, int j ) { int res = 0; for(int k = i; k <= j; k++) res += cartas[k]; return res; }

	public Robanumeros( int[] cartas ){
		this.cartas = cartas;
	}

	private int f(int i, int j) {
		if( i < j ){
			int min_ij = Integer.MAX_VALUE;
			for( int k = i; k <= j; k++ ){
				min_ij = min(min_ij, min(f(i, k - 1), f(k + 1, j)));
			}
			return sum(i,j) - min_ij;
		}
		if( i == j && i >= 0 && i < cartas.length ){
			return cartas[i];
		}
		return 0;
	}

	public void calcularOptimoPuntaje(){
		puntos = f(0, cartas.length - 1);
	}

	public int getOptimoPuntaje(){
		return puntos;
	}

}
