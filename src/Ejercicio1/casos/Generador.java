package Ejercicio1.casos;
import Ejercicio1.main.InstanceEj1;

public class Generador {
	private static GeneradorCasos generadorDeCasos( String tipo ) throws Exception {
		if ( tipo.equals( "mejor" ) )
			return new GenerarAleatorioCaso();
		else if ( tipo.equals( "peor" ) )
			return new GenerarAleatorioCaso();
		else if ( tipo.equals( "aleatorio" ) )
			return new GenerarAleatorioCaso();

		throw new Exception( "Generador de casos no reconocido: " + tipo );
	}
	
	public static void main( String[] args ) throws Exception {
		if ( args.length <= 1 || args.length > 4 ) {
			System.err.println( "Uso: Generador desde hasta [veces [tipo]]" );
			System.err.println( " * desde: Número de casos de comienzo." );
			System.err.println( " * hasta: Número de casos de finalización." );
			System.err.println( " * veces: Cantidad de veces a correr el mismo caso y promediar. [default=3]" );
			System.err.println( " * tipo: Tipo de casos a generar: peor|mejor|aleatorio. [default=aleatorio]" );
			return;
		}

		int desde = Integer.parseInt( args[0] );
		int hasta = Integer.parseInt( args[1] );
		int veces = 3;
		GeneradorCasos generador;

		switch( args.length ) {
			case 4:
				veces = Integer.parseInt( args[2] );
				generador = generadorDeCasos( args[3] );
				break;
			case 3:
				veces = Integer.parseInt( args[2] );
			default:
				generador = generadorDeCasos( "aleatorio" );
		}

		for ( int i = desde; i <= hasta; i++ ) {
			long tiempo = 0;
			InstanceEj1 ej = new InstanceEj1();
			ej.receiveInput( generador.generarCaso( i ) );

			for ( int j = 0; j < veces; j++ ) {
				long t0 = System.nanoTime();
				ej.resolve();
				tiempo += System.nanoTime() - t0;
				ej.reset();
			}

			System.out.println( Integer.toString( i ) + "\t" + Double.toString( (double) tiempo / (double) veces ) );
		}
	}
}
