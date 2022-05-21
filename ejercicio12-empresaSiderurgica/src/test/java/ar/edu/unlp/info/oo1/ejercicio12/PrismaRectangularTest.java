package ar.edu.unlp.info.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {
	private PrismaRectangular pris1;
	private PrismaRectangular pris2;
	
	@BeforeEach
	void setUp() {
		pris1= new PrismaRectangular(10, 5, 8, "Hierro", "Rojo");
		pris2= new PrismaRectangular(20, 10, 16, "Madera", "Verde");
	}
	
	@Test
	void testGetVolumen() {
		assertEquals(400, pris1.getVolumen());
		assertEquals(3200, pris2.getVolumen());
	}
	
	@Test
	void testGetSuperficie() {
		assertEquals(340, pris1.getSuperficie());
		assertEquals(1360, pris2.getSuperficie());
	}
}
