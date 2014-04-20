package Ejercicio1.casos;

public class GenerarAleatorioCaso implements GeneradorCasos {
	private static int random( int min, int max ) {
		return (int) Math.ceil( Math.random() * (double) (max - min) + (double) min );
	}

	public String generarCaso( int tamano ) {
		StringBuilder res = new StringBuilder();
		res.append( tamano );
		res.append( " " );
		while ( tamano-- > 0 ) {
			res.append( random( -10, 10 ) );
			res.append( " " );
		}

		return res.toString();
	}
}
