package Ejercicio1.main;

import Ejercicio1.model.Robanumeros;
import Otros.Ejercicio;

public class InstanceEj1 implements Ejercicio {
	private int[] cartas;
	private Robanumeros juego;

	public void receiveInput( String input ){
		boolean primero = true;
		int indice = 0;
		for ( String str : input.split( " " ) ) {
			if ( primero ) {
				cartas = new int[Integer.parseInt(str)];
				primero = false;
				continue;
			}
			cartas[indice++] = Integer.parseInt(str);
		}

		juego = new Robanumeros( cartas );
	}

	public void resolve(){
		juego.calcularOptimoPuntaje();
	}

	public void reset(){
		juego = new Robanumeros( cartas );
	}

	public String getOutput(){
		return String.valueOf( juego.getOptimoPuntaje() );
	}
}
