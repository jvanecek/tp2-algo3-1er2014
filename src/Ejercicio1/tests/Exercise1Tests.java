package Ejercicio1.tests;

import Ejercicio1.main.InstanceEj1;
import org.junit.Assert;
import org.junit.Test;

public class Exercise1Tests {
	@Test
	public void testEligeSolucionesNoSubOptimasParaGanar() {
		InstanceEj1 e = new InstanceEj1();
		String exp1 = "2 3 -7\nder 1\nizq 3\n";
		String exp2 = "2 3 -7\nder 1\nder 3\n";
		
		e.receiveInput( "4 1 -10 2 3" );
		e.resolve();
		
		Assert.assertTrue( exp1.equals( e.getOutput() ) || exp2.equals( e.getOutput() ) );
	}

	@Test
	public void testEligeNegativosParaAumentarDiferencia() {
		InstanceEj1 e = new InstanceEj1();
		String exp1 = "1 5 0\nizq 4\n";
		String exp2 = "1 5 0\nder 4\n";
		
		e.receiveInput( "4 10 -10 2 3" );
		e.resolve();
		
		Assert.assertTrue( exp1.equals( e.getOutput() ) || exp2.equals( e.getOutput() ) );
	}

	@Test
	public void testFuncionaConNegativos() {
		InstanceEj1 e = new InstanceEj1();
		String exp1 = "2 -5 -6\nizq 2\nizq 1\n";
		String exp2 = "2 -5 -6\nizq 2\nder 1\n";
		
		e.receiveInput( "3 -1 -4 -6" );
		e.resolve();

		Assert.assertTrue( exp1.equals( e.getOutput() ) || exp2.equals( e.getOutput() ) );
	}

	@Test
	public void testPierdePorLoMenosPosible() {
		InstanceEj1 e = new InstanceEj1();
		String exp1 = "1 -8 0\nizq 3\n";
		String exp2 = "1 -8 0\nder 3\n";
		
		e.receiveInput( "3 1 -10 1" );
		e.resolve();

		Assert.assertTrue( exp1.equals( e.getOutput() ) || exp2.equals( e.getOutput() ) );
	}
}
