package ar.edu.unlp.info.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {
	private Esfera esf1;
	private Esfera esf2;
	
	@BeforeEach
	public void setUp() {
		esf1= new Esfera(5, "Hierro", "Rojo");
		esf2= new Esfera(10, "Madera", "Verde");
	}
	
	@Test
	void testGetVolumen() {
		assertEquals(524, Math.round(esf1.getVolumen()));
		assertEquals(4189, Math.round(esf2.getVolumen()));
	}
	
	@Test
	void testGetSuperficie() {
		assertEquals(314, Math.round(esf1.getSuperficie()));
		assertEquals(1257, Math.round(esf2.getSuperficie()));
	}

}
