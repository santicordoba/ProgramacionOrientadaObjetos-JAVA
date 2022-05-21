package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
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
		empleado1.agregarContrato(horas);
		empleado2.agregarContrato(planta);
		empleado3.agregarContrato(vencido);
	}
	
	@Test
	void testAgregarContrato() {
		assertEquals(1, empleado1.getContratos().size());
		assertEquals(1, empleado2.getContratos().size());
		empleado3.agregarContrato(planta);
		assertEquals(2, empleado3.getContratos().size());
	}
	
	@Test 
	void testContratoVencido() {
		assertTrue(empleado3.contratoVencido());
		empleado3.agregarContrato(planta);
		assertFalse(empleado3.contratoVencido());
	}
	
	@Test
	void testAntiguedad() {
		assertEquals(0, empleado1.antiguedad());
		empleado3= new Empleado("Santiago", "Cordoba", "20373570150", LocalDate.of(1993, 06, 11), LocalDate.of(2020, 10, 25));
		assertEquals(1, empleado3.antiguedad());
	}
	
	@Test
	void testSueldo() {
		assertEquals(60000, empleado1.sueldo());
		assertEquals(44000, empleado2.sueldo());
		empleado2= new Empleado("Santiago", "Cordoba", "20373570150", LocalDate.of(1993, 06, 11), LocalDate.of(2016, 10, 25));
		empleado2.agregarContrato(planta);
		assertEquals(5, empleado2.antiguedad());
		assertEquals(57200, empleado2.sueldo());
	}
}

