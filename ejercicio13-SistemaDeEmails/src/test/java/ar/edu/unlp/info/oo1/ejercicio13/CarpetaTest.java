package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	private Carpeta c1;
	private Carpeta c2;
	private Email em1;
	private Email em2;
	private Email em3;
	private Archivo ar1;
	
	@BeforeEach
	void setUp() {
		c1= new Carpeta("Inbox");
		c2= new Carpeta("Spam");
		em1= new Email("Hola","Juan Carlos");
		em2= new Email("Como estas", "Chupapija");
		em3= new Email("Pago", "Pago");
		ar1= new Archivo("Presentacion");
		em1.agregarAdjunto(ar1);
		c1.agregarEmail(em1);
		c2.agregarEmail(em2);
		c1.agregarEmail(em3);
	}
	
	@Test
	void testTamanio() {
		assertEquals(35, c1.tamanio());
		assertEquals(19, c2.tamanio());
	}

}
