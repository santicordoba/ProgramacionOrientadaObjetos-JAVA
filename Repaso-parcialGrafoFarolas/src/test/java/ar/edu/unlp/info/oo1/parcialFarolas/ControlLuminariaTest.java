package ar.edu.unlp.info.oo1.parcialFarolas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControlLuminariaTest {
	private ControlLuminaria empresa;
	private ControlLuminaria empresa2;
	private Farola red1;
	private Farola red2;
	private Farola red3;
	private Farola farola11;
	private Farola farola12;
	private Farola farola21;
	private Farola farola22;
	private Farola farola31;
	private Farola farola32;
	
	@BeforeEach
	void setUp() {
		empresa= new ControlLuminaria();
		empresa2= new ControlLuminaria();
		//creo red1
		red1= new Farola(false);
		farola11= new Farola(false);
		farola12= new Farola(false);
		red1.agregarVecina(farola11);
		red1.agregarVecina(farola12);
		empresa.agregarRed(red1);
		//creo red2
		red2= new Farola(true);
		farola21= new Farola(true);
		farola22= new Farola(true);
		red2.agregarVecina(farola21);
		farola21.agregarVecina(farola22);
		empresa2.agregarRed(red2);
	}
	
	@Test
	void testEstadoNocturno() {
		assertFalse(empresa.estadoNocturno());
		assertTrue(empresa2.estadoNocturno());
		empresa.agregarRed(red2);
		assertTrue(empresa.estadoNocturno());
	}
	
	@Test
	void controlarLuminarias() {
		empresa2.controlarLuminarias();
		assertTrue(red2.redEncendida());
		empresa.controlarLuminarias();
		assertFalse(red1.redEncendida());
		farola31= new Farola(true);
		red1.agregarVecina(farola31);
		assertTrue(empresa.estadoNocturno());
		empresa.controlarLuminarias();
		assertTrue(red1.redEncendida());
		red1.apagar();
		assertFalse(red1.redEncendida());
		empresa.controlarLuminarias();
		assertTrue(red1.redEncendida());
	}
	
	@Test
	void testDeApagar() {
		red1.encender();
		assertTrue(red1.redEncendida());
		assertFalse(empresa.estadoNocturno());
		empresa.controlarLuminarias();
		assertFalse(red1.redEncendida());
	}

}
