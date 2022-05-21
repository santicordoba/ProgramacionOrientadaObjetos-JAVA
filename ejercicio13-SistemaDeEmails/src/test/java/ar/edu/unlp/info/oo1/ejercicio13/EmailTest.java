package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	private Email em1;
	private Email em2;
	private Archivo ar1;

	@BeforeEach
	public void setUp() {
		em1= new Email("Hola","Juan Carlos");
		em2= new Email("Como estas", "Chupapija");
		ar1= new Archivo("Presentacion");
		em1.agregarAdjunto(ar1);
	}
	
	@Test
	void testTamanioEmail() {
		assertEquals(27, em1.tamanio());
		assertEquals(19, em2.tamanio());
	}

}



