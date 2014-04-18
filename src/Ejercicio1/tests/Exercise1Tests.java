package Ejercicio1.tests;
import Ejercicio1.main.InstanceEj1;
import org.junit.Test;
import org.junit.Assert;

public class Exercise1Tests {
	@Test
	public void testEligeSolucionesNoSubOptimasParaGanar() {
		InstanceEj1 e = new InstanceEj1();
		e.receiveInput( "4 1 -10 2 3" );
		e.resolve();
		Assert.assertEquals( "3", e.getOutput() );
	}

	@Test
	public void testEligeNegativosParaAumentarDiferencia() {
		InstanceEj1 e = new InstanceEj1();
		e.receiveInput( "4 10 -10 2 3" );
		e.resolve();
		Assert.assertEquals( "5", e.getOutput() );
	}

	@Test
	public void testFuncionaConNegativos() {
		InstanceEj1 e = new InstanceEj1();
		e.receiveInput( "3 -1 -4 -6" );
		e.resolve();
		Assert.assertEquals( "-5", e.getOutput() );
	}

	@Test
	public void testPierdePorLoMenosPosible() {
		InstanceEj1 e = new InstanceEj1();
		e.receiveInput( "3 1 -10 1" );
		e.resolve();
		Assert.assertEquals( "-8", e.getOutput() );
	}
}
