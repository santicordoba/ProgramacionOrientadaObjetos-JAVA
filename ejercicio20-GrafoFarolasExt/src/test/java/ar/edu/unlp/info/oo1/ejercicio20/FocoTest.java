package ar.edu.unlp.info.oo1.ejercicio20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FocoTest {
	private Foco foco1;
	private Foco foco2;
	
	
	@BeforeEach
	void setUp() {
		foco1= new Foco("Osram", 2);
		foco2= new Foco("Philips", 5);
	}
	
	@Test
	void testContarUso() {
		assertEquals(0, foco1.getCantCiclos());
		foco2.contarUso();
		assertEquals(1, foco2.getCantCiclos());
	}
	
	@Test
	void testVencido() {
		foco1.contarUso();
		foco1.contarUso();
		foco1.contarUso();
		assertTrue(foco1.vencido());
		assertFalse(foco2.vencido());
	}
}
