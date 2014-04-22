package Ejercicio1.model;

/**
 * Created by juan on 20/04/14.
 */
public class RobanumerosEze {
	private int[] cartas; /**< Cartas del juego. */
	private int puntos; /**< Puntaje del jugador 1 del juego finalizado. */
	private Cache cacheIzq, cacheDer;

	private static final int MI_TURNO = 1;
	private static final int TU_TURNO = 2;

	private int max( int a, int b ) { return a < b ? b : a; }
	private int min( int a, int b ) { return a < b ? a : b; }

	public Robanumeros( int[] cartas ){
		this.cartas = cartas;
		cacheIzq = new Cache( cartas );
		cacheDer = new Cache( cartas );
	}

	private void construir() {
		int n = cartas.length;

		for ( int i = 1; i < n; i++ ) {
			for ( int j = i; j < n; j++ ) {
				// Desde la izquierda
				int puntos = 0;
				int maximo = Integer.MIN_VALUE;
				int minimo = Integer.MAX_VALUE;
				for ( int p = j - i; p < j; p++ ) {
					puntos += cartas[p];
					int minI = cacheIzq.get( p + 1, j, TU_TURNO );
					int minD = cacheDer.get( p + 1, j, TU_TURNO );
					int maxI = cacheIzq.get( p + 1, j, MI_TURNO );
					int maxD = cacheDer.get( p + 1, j, MI_TURNO );
					minimo = min( minimo, max( maxI, maxD ) );
					maximo = max( maximo, puntos + min( minI, minD ) );
				}
				puntos += cartas[j];
				minimo = min( minimo, 0 );
				maximo = max( maximo, puntos );
				cacheIzq.set( j - i, j, MI_TURNO, maximo );
				cacheIzq.set( j - i, j, TU_TURNO, minimo );

				// Desde la derecha
				maximo = Integer.MIN_VALUE;
				minimo = Integer.MAX_VALUE;
				puntos = 0;
				for ( int p = j; p > j - i; p-- ) {
					puntos += cartas[p];
					int minI = cacheIzq.get( j - i, p - 1, TU_TURNO );
					int minD = cacheDer.get( j - i, p - 1, TU_TURNO );
					int maxI = cacheIzq.get( j - i, p - 1, MI_TURNO );
					int maxD = cacheDer.get( j - i, p - 1, MI_TURNO );
					minimo = min( minimo, max( maxI, maxD ) );
					maximo = max( maximo, puntos + min( minI, minD ) );
				}
				puntos += cartas[j-i];
				minimo = min( minimo, 0 );
				maximo = max( maximo, puntos );
				cacheDer.set( j - i, j, MI_TURNO, maximo );
				cacheDer.set( j - i, j, TU_TURNO, minimo );
			}
		}
	}

	public void calcularOptimoPuntaje(){
		construir();
		int maxI = cacheIzq.get( 0, cartas.length - 1, MI_TURNO );
		int maxD = cacheDer.get( 0, cartas.length - 1, MI_TURNO );
		puntos = max( maxI, maxD );
	}

	public int getOptimoPuntaje(){
		return puntos;
	}
}
