package Ejercicio3.tests;

import Ejercicio3.model.Nodo;
import Ejercicio3.model.Tablero;
import java.util.List;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class TestTablero {


	@Test
	public void testRangos(){
		int n = 3;
		Tablero T = new Tablero(n,0,0,0,0,0,new int[n][n]);

		Assert.assertFalse( T.estaEnTablero(-1,-1) );
		Assert.assertFalse( T.estaEnTablero(-1,2) );
		Assert.assertFalse( T.estaEnTablero(2,0) );
		Assert.assertFalse( T.estaEnTablero(2,5) );
		Assert.assertTrue( T.estaEnTablero(1,3) );
		Assert.assertTrue( T.estaEnTablero(2,2) );
		Assert.assertFalse( T.estaEnTablero(0,1) );
	}

	@Test
	public void testAdyacentes(){
		// testear que siempre devuelva los adyacentes correspondientes
	}

	@Test
	public void testearEncuentraMinimasDistancias(){
		// testear que siempre encuentre la distancia minima
	}

	@Test
	public void testearCorrectaConstruccion(){
		// testear que construye la secuencia de pasos correctas
	}
}
