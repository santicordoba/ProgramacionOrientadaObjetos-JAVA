package ar.edu.unlp.info.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {
	private CajaDeAhorro caja1, caja2, caja3, caja4;
	private CuentaCorriente corriente;
	
	@BeforeEach
	public void setUp() {
		this.caja1= new CajaDeAhorro();
		this.caja2= new CajaDeAhorro();
		this.caja3= new CajaDeAhorro();
		this.caja4= new CajaDeAhorro();
		this.corriente= new CuentaCorriente();
		this.corriente.setLimite(0);
		caja3.depositar(200);
		caja4.depositar(200);
	}
	
	@Test
	public void testDepositar() {
		caja1.depositar(200);
		assertEquals(196, caja1.getSaldo());
		assertEquals(0, caja2.getSaldo());
	}
	
	@Test
	public void testPuedeExtraer() {
		assertTrue(caja3.puedeExtraer(190));
		assertFalse(caja3.puedeExtraer(196));
		assertFalse(caja2.puedeExtraer(2000));
	}
	
	@Test
	public void testExtraerSinControlar() {
		caja3.extraerSinControlar(100);
		assertEquals(94, caja3.getSaldo());
	}
	
	@Test
	public void testTransferirACuenta() {
		caja3.transfererirACuenta(100, caja2);
		caja4.transfererirACuenta(100, corriente);
		assertEquals(94, caja3.getSaldo());
		assertEquals(98, caja2.getSaldo());
		assertEquals(94, caja4.getSaldo());
		assertEquals(100, corriente.getSaldo());
	}

}
