package Ejercicio1.main;

import Ejercicio1.model.Robanumeros;
import Otros.Ejercicio;

public class InstanceEj1 implements Ejercicio {
	private int[] cartas;
	private Robanumeros juego;

	@Override
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

	@Override
	public void resolve(){
		juego.calcularSolucion();
	}

	@Override
	public void reset(){
		juego = new Robanumeros( cartas );
	}

	@Override
	public String getOutput(){
		return juego.obtenerSolucion();
	}
}
