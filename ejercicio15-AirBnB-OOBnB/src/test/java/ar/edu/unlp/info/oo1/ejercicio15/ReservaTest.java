package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
	private Reserva res1;
	//private Reserva res2;
	private DateLapse periodo1;
	private Usuario usuario;
	private Propiedad prop1;
	
	@BeforeEach
	void setUp() {
		periodo1= new DateLapse(LocalDate.of(2021, 6, 28), LocalDate.of(2021, 6, 30));
		usuario= new Usuario("Carlitos", "14 y 20", 17000000);
		prop1= new Propiedad("Quinta", "con pileta", 2000, "13 y 23", usuario);
		res1= new Reserva(periodo1, usuario, prop1);
	}
	
	@Test
	void testValor() {
		assertEquals(4000, res1.valor());
	}
}
