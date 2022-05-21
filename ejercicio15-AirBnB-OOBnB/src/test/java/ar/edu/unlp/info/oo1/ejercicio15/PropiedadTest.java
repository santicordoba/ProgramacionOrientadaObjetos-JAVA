package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
	private ServicioDeRegistros empresa;
	private Usuario usuario1;
	private Usuario usuario2;
	private DateLapse periodo1;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	
	@BeforeEach
	void setUp() {
		empresa= new ServicioDeRegistros();
		usuario1=empresa.registrarUsuario("Carlitos", "14 y 20", 17000000);
		usuario2=empresa.registrarUsuario("Pancho", "20 y 17", 15000000);
		propiedad1= empresa.registrarPropiedad("Casita", "Con quincho", 2400, "laguna mulita", usuario1);
		propiedad2= empresa.registrarPropiedad("Depto", "Con balcon", 2400, "Barrio Fonavi", usuario2);
		periodo1= new DateLapse(LocalDate.of(2021, 6, 28), LocalDate.of(2021, 6, 30));
		empresa.hacerUnaReserva(propiedad2, periodo1, usuario1);
	}
	
	@Test
	void testLibre() {
		assertEquals(true, propiedad1.libre(periodo1));
		assertEquals(false, propiedad2.libre(periodo1));
	}

}
