package ar.edu.unlp.info.oo1.parcialFarolas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FarolaTest {
	private Farola farola1;
	private Farola farola2;
	private Farola farola3;
	
	@BeforeEach
	void setUp() {
		farola1= new Farola(false);
		farola2= new Farola(false);
		farola3= new Farola(false);
		farola1.agregarVecina(farola2);
		farola2.agregarVecina(farola3);
	}
	
	@Test
	void testEstadoNocturno() {
		assertFalse(farola1.estadoNocturno());
	}
	
	@Test
	void redEncendida() {
		assertFalse(farola1.redEncendida());
	}
	
	@Test
	void testEncender() {
		farola1.encender();
		assertTrue(farola1.redEncendida());
		farola1.apagar();
		assertFalse(farola1.redEncendida());
	}
}
