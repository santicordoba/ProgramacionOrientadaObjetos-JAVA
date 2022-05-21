package ar.edu.unlp.info.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {
	private ReporteDeConstruccion reporte;
	private Pieza cil1;
	private Pieza cil2;
	private Pieza esf1;
	private Pieza esf2;
	private Pieza pris1;
	private Pieza pris2;
	
	@BeforeEach
	void setUp() {
		reporte= new ReporteDeConstruccion();
		cil1 = new Cilindro(2, 5, "Hierro", "Rojo");
    	cil2 = new Cilindro(2, 10, "Madera", "Verde");
    	esf1 = new Esfera(5, "Hierro", "Rojo");
		esf2 = new Esfera(10, "Madera", "Verde");
		pris1 = new PrismaRectangular(10, 5, 8, "Hierro", "Rojo");
		pris2 = new PrismaRectangular(20, 10, 16, "Madera", "Verde");
		reporte.agregarPieza(cil1);
		reporte.agregarPieza(cil2);
		reporte.agregarPieza(esf1);
		reporte.agregarPieza(esf2);
		reporte.agregarPieza(pris1);
		reporte.agregarPieza(pris2);
	}
	
	@Test
	void testAgregarPieza() {
		assertEquals(6, reporte.getPiezas().size());
	}
	
	@Test
	void testVolumenDeMaterial(){
		assertEquals(986.0, Math.round(reporte.volumenDeMaterial("Hierro")));
		assertEquals(7514.0, Math.round(reporte.volumenDeMaterial("Madera")));
	}
	
	@Test
	void testSuperficieDeMaterial() {
		assertEquals(742.0, Math.round(reporte.superficieDeColor("Rojo")));
		assertEquals(2767.0, Math.round(reporte.superficieDeColor("Verde")));
	}
	
}
