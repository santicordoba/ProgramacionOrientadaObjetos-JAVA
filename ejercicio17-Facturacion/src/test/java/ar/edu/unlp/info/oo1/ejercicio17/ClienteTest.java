package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
	private Cliente cli1;
	private Cliente cli2;
	private DateLapse periodo;
	
	@BeforeEach
	void setUp() {
		cli1= new Individuo("Juan Carlos", "9 y 59", 5367771, 37357015);
		cli2= new Juridico("Kyoto", "9 y 59", 5367772, 373570150, "Empresa");
		cli1.hacerLlamada(684577, LocalDate.of(2021, 10, 24), LocalTime.of(20, 45), 2);
		cli2.hacerLlamada(684577, LocalDate.of(2021, 10, 24), LocalTime.of(20, 45), 2);
		cli1.hacerLlamada(684577, LocalDate.of(2021, 10, 24), LocalTime.of(20, 45), 2, 200);
		periodo= new DateLapse(LocalDate.of(2020, 1, 1), LocalDate.of(2022, 12, 31));
	}
	
	@Test
	void testHacerLlamada() {
		assertEquals(2, cli1.getLlamadas().size());
		assertEquals(1, cli2.getLlamadas().size());
	}
	
	@Test
	void testCostoEnPeriodo() {
		assertEquals(10.8, cli1.costoEnPeriodo(periodo));
		assertEquals(2, cli2.costoEnPeriodo(periodo));
	}
}
