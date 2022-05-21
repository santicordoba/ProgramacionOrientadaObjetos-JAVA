package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicioDeRegistrosTest {
	private ServicioDeRegistros empresa;
	private Usuario usuario1;
	private Usuario usuario2;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private DateLapse periodo3;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Propiedad propiedad3;
	private DateLapse periodo4;
	private Reserva res;
	
	@BeforeEach
	void setUp() {
		empresa= new ServicioDeRegistros();
		usuario1= new Usuario("Carlitos", "14 y 20", 17000000);
		propiedad3= empresa.registrarPropiedad("Casita", "Con quincho", 2400, "laguna mulita", usuario1);
		empresa.registrarUsuario("Carlitos", "14 y 20", 17000000);
		usuario1=empresa.registrarUsuario("Carlitos", "14 y 20", 17000000);
		usuario2=empresa.registrarUsuario("Pancho", "20 y 17", 15000000);
		propiedad1= empresa.registrarPropiedad("Casita", "Con quincho", 2400, "laguna mulita", usuario1);
		propiedad2= empresa.registrarPropiedad("Depto", "Con balcon", 2400, "Barrio Fonavi", usuario2);
		periodo1= new DateLapse(LocalDate.of(2021, 6, 28), LocalDate.of(2021, 6, 30));
		periodo2= new DateLapse(LocalDate.of(2021, 6, 29), LocalDate.of(2021, 7, 5));
		periodo3= new DateLapse(LocalDate.of(2021, 6, 1), LocalDate.of(2021, 7, 30));
		periodo4= new DateLapse(LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 5));
	}
	
	@Test
	void testRegistros() {
		assertEquals(3, empresa.getUsuarios().size());
		assertEquals(3, empresa.getPropiedades().size());
	}
	
	@Test
	void testHacerUnaReserva() {
		assertNotNull(empresa.hacerUnaReserva(propiedad2, periodo1, usuario1));
		assertNull(empresa.hacerUnaReserva(propiedad2, periodo2, usuario2));
		assertNotNull(empresa.hacerUnaReserva(propiedad1, periodo1, usuario1));
		assertNotNull(empresa.hacerUnaReserva(propiedad3, periodo1, usuario1));
	}
	
	@Test
	void testBuscarPropiedad() {
		assertEquals(3, empresa.buscarPropiedad(periodo1).size());
		empresa.hacerUnaReserva(propiedad2, periodo1, usuario1);
		assertEquals(2, empresa.buscarPropiedad(periodo1).size());
	}
	
	@Test
	void testCalcularIngresosPropietario() {
		empresa.hacerUnaReserva(propiedad2, periodo1, usuario1);
		assertEquals(4800, empresa.calcularIngresosPropietario(periodo1, usuario2));
		assertNotNull(empresa.hacerUnaReserva(propiedad2, periodo4, usuario1));
		assertEquals(14400, empresa.calcularIngresosPropietario(periodo3, usuario2));
		assertEquals(0, empresa.calcularIngresosPropietario(periodo3, usuario1));
	}
	
	@Test
	void testEliminarReserva() {
		periodo1= new DateLapse(LocalDate.of(2021, 10, 28), LocalDate.of(2021, 10, 30));
		res=empresa.hacerUnaReserva(propiedad2, periodo1, usuario1);
		assertEquals(1, propiedad2.getReservas().size());
		empresa.eliminarReserva(res);
		assertEquals(0, propiedad2.getReservas().size());
	}
}
