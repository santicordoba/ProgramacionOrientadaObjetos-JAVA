package ar.edu.unlp.info.oo1.ejercicio18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

public class ContratoTest {
	private Contrato horas;
	private Contrato planta;
	private Contrato vencido;
	private Empleado empleado1;
	private Empleado empleado2;
	private Empleado empleado3;
	
	@BeforeEach
	void setUp() {
		empleado1= new Empleado("Santiago", "Cordoba", "20373570150", LocalDate.of(1993, 06, 11), LocalDate.now());
		empleado2= new Empleado("Santiago", "Cordoba", "20373570150", LocalDate.of(1993, 06, 11), LocalDate.now());
		empleado3= new Empleado("Santiago", "Cordoba", "20373570150", LocalDate.of(1993, 06, 11), LocalDate.now());
		horas= new PorHoras(empleado1, LocalDate.of(2021, 10, 01), 500.0, 120, LocalDate.of(2021, 10, 31));
		planta= new Planta(empleado2, LocalDate.of(2021, 10, 1), 40000.0, 3000, 1000);
		vencido= new PorHoras(empleado3, LocalDate.of(2021, 10, 01), 500.0, 120, LocalDate.of(2021, 10, 25));
	}
	
	@Test
	void testMontoBasico() {
		assertEquals(60000, horas.montoBasico());
		assertEquals(44000, planta.montoBasico());
	}
	
	@Test
	void testActivo() {
		assertTrue(planta.activo());
		assertTrue(horas.activo());
		assertFalse(vencido.activo());
	}
}
