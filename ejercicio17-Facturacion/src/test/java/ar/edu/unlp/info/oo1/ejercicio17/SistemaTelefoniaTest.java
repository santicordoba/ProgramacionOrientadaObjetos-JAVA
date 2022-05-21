package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTelefoniaTest {
	private SistemaTelefonia empresa;
	private Cliente cli1;
	private Cliente cli2;
	private DateLapse periodo;
	private Factura factura;
	
	@BeforeEach
	void setUp() {
		empresa= new SistemaTelefonia();
		empresa.agregarNumero(5367771);
		empresa.agregarNumero(2345125);
		empresa.agregarNumero(2512522);
		cli1= empresa.altaCliente("Juan Carlos", "9 y 59", 37357015);
		cli2= empresa.altaCliente("Kyoto", "9 y 59", 373570150, "Empresa");
		cli1.hacerLlamada(684577, LocalDate.of(2021, 10, 24), LocalTime.of(20, 45), 2);
		cli2.hacerLlamada(684577, LocalDate.of(2021, 10, 24), LocalTime.of(20, 45), 2);
		cli1.hacerLlamada(684577, LocalDate.of(2021, 10, 24), LocalTime.of(20, 45), 2, 200);
		periodo= new DateLapse(LocalDate.of(2020, 1, 1), LocalDate.of(2022, 12, 31));
		Factura factura;
	}
	
	@Test
	void testNumeros() {
		assertEquals(1, empresa.getTelefonosDisponibles().size());
	}
	
	@Test
	void testClientes() {
		assertEquals(2, empresa.getClientes().size());
	}
	
	@Test
	void testFacturar() {
		factura= empresa.facturar(cli1, periodo);
		empresa.facturar(cli2, periodo);
		assertEquals(1, cli1.getFacturas().size());
		assertEquals(10.8, factura.getMonto());
	}

}
