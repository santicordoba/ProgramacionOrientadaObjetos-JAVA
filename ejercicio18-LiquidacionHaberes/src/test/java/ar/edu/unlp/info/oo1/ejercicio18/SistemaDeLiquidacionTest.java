package ar.edu.unlp.info.oo1.ejercicio18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

public class SistemaDeLiquidacionTest {
	private SistemaDeLiquidacion sistema;
	private Empleado empleado1;
	private Empleado empleado2;
	private Empleado empleado3;
	private Empleado empleado4;
	
	@BeforeEach
	void setUp() {
		sistema= new SistemaDeLiquidacion();
		empleado1= sistema.altaEmpleado("Santiago", "Cordoba", "20373570150", LocalDate.of(1993, 06, 11));
		empleado2= sistema.altaEmpleado("Juan Carlos", "Espiritu", "404142", LocalDate.of(2021, 10, 11));
		empleado3= sistema.altaEmpleado("Terere", "Pomelo", "012345", LocalDate.of(2021, 10, 27));
		sistema.cargarContrato(empleado1, LocalDate.of(2021, 10, 1), 70000, 10000, 1000);
		sistema.cargarContrato(empleado2, LocalDate.now(), 300, 120, LocalDate.of(2021, 12, 31));
		sistema.cargarContrato(empleado3, LocalDate.now(), 200, 1, LocalDate.of(2020, 12, 31));
	}
	
	@Test
	void testAlta() {
		assertEquals(3, sistema.getEmpleados().size());
	}
	
	@Test
	void testBuscarEmpleado() {
		assertEquals(empleado1, sistema.buscarEmpleado("20373570150"));
		assertNull(sistema.buscarEmpleado("20"));
	}
	
	@Test
	void testBaja() {
		sistema.bajaEmpleado(empleado1);
		assertEquals(2, sistema.getEmpleados().size());
	}
	
	@Test
	void testCargaContratos() {
		assertEquals(1, empleado1.getContratos().size());
		assertEquals(1, empleado2.getContratos().size());
	}
	
	@Test
	void testContratosVencidos() {
		List<Empleado> lista= sistema.obtenerEmpleadosContratosVencidos();
		assertEquals(1, lista.size());
		empleado4= sistema.altaEmpleado("Terere", "Pomelo", "012345", LocalDate.of(2021, 10, 27));
		sistema.cargarContrato(empleado4, LocalDate.now(), 200, 1, LocalDate.of(2020, 12, 31));
		assertEquals(2, sistema.obtenerEmpleadosContratosVencidos().size());
	}
	
	@Test
	void testEmpleadosActivos() {
		List<Empleado> lista= sistema.obtenerEmpleadosActivos();
		assertEquals(2, lista.size());
	}
	
	@Test
	void testGenerarRecibos() {
		List<Recibo> lista= sistema.generarRecibos();
		assertEquals(2, sistema.getRecibos().size());
		assertEquals(81000, lista.get(0).getMontoTotal());
		assertEquals(36000, lista.get(1).getMontoTotal());
	}
}

