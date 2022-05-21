package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {
	private Carpeta c1;
	private Carpeta c2;
	private Email em1;
	private Email em2;
	private Email em3;
	private Email em4;
	private Archivo ar1;
	private ClienteDeCorreo cl;
	
	@BeforeEach
	void setUp() {
		c1= new Carpeta("Inbox");
		c2= new Carpeta("Spam");
		em1= new Email("Hola","Juan Carlos");
		em2= new Email("Hola", "Chupapija");
		em3= new Email("Pago", "Hola");
		em4= new Email("Prueba", "Hola");
		ar1= new Archivo("Presentacion");
		em1.agregarAdjunto(ar1);
		c1.agregarEmail(em1);
		c2.agregarEmail(em2);
		c1.agregarEmail(em3);
		cl= new ClienteDeCorreo();
		cl.agregarCarpeta(c1);
		cl.agregarCarpeta(c2);
	}
	
	@Test
	void testEspacioOcupado() {
		assertEquals(48, cl.espacioOcupado());
	}
	
	@Test
	void testBuscar() {
		Email e= cl.buscar("Hola");
		assertEquals("Juan Carlos", e.getCuerpo());
	}
	
	@Test
	void recibir() {
		cl.recibir(em1);
		assertEquals(1, cl.getInbox().getEmails().size());
	}
	
	@Test 
	void testMover(){
		cl.recibir(em4);
		cl.mover(em4, cl.getInbox(), c1);
		assertEquals(0, cl.getInbox().getEmails().size());
		assertEquals(3, c1.getEmails().size());
	}

	
}
