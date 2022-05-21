package ar.edu.unlp.info.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
	private CuentaCorriente cuenta1, cuenta2;
	private CajaDeAhorro caja1;
	
	@BeforeEach
	public void setUp() {
		this.cuenta1= new CuentaCorriente();
		this.cuenta2= new CuentaCorriente();
		this.caja1= new CajaDeAhorro();
		this.cuenta1.setLimite(200);
	}
	
	@Test
	public void testDepositar() {
		cuenta1.depositar(200);
		assertEquals(200, cuenta1.getSaldo());
		assertEquals(0, cuenta2.getSaldo());		
	}
	
	@Test
	public void testPuedeExtraer() {
		assertTrue(cuenta1.puedeExtraer(200));
		assertFalse(cuenta1.puedeExtraer(201));
		assertFalse(cuenta2.puedeExtraer(2000));
	}
	
	@Test
	public void testExtraerSinControlar() {
		cuenta1.extraerSinControlar(100);
		assertEquals(-100, cuenta1.getSaldo());
	}
	
	@Test
	public void testTransferirACuenta() {
		cuenta1.transfererirACuenta(100, cuenta2);
		cuenta1.transfererirACuenta(100, caja1);
		assertEquals(-200, cuenta1.getSaldo());
		assertEquals(100, cuenta2.getSaldo());
		assertEquals(98, caja1.getSaldo());
	}
}
