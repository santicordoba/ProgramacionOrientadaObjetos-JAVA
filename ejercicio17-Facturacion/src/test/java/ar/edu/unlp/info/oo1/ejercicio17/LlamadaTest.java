package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaTest {
	private Llamada llamada1;
	private Llamada llamada2;
	private Llamada llamada3;
	
	@BeforeEach
	void setUp() {
		llamada1= new LlamadaLocal(5367771, 6184132, LocalDate.of(20112, 2, 14), LocalTime.of(20, 0), 2);
		llamada2= new LlamadaInterurbana(5367771, 6184132, LocalDate.of(2021, 10, 20), LocalTime.of(00, 00), 10, 200);
		llamada3= new LlamadaInternacional(5367771, 6184132, LocalDate.of(2022, 2, 10), LocalTime.of(16, 45), 2, "Argentina", "China");
	}

	@Test
	void testCosto() {
		assertEquals(2, llamada1.costo());
		assertEquals(30, llamada2.costo());
		assertEquals(8, llamada3.costo());
	}
}
