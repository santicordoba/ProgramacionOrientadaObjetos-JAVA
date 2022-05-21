package ar.edu.unlp.info.oo1.parcialFecha1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TestParcial {
	private FacturaExportacion conItems;
	private FacturaExportacion sinItems;
	private Item bien;
	private Item servicio;
	
	@BeforeEach
	void setUp() {
		bien= new Bien("Caja precintos", 2, 2.5, 400.0);
		servicio= new Servicio("Consultario", 800, 10000);
		List<Item> items= new ArrayList<Item>();
		items.add(bien);
		items.add(servicio);
		conItems= new FacturaExportacion(LocalDate.of(2021, 10, 31), LocalDate.of(2021, 11, 1), items);
		List<Item> listaVaciaItems= new ArrayList<Item>();
		sinItems= new FacturaExportacion(LocalDate.of(2021, 10, 31), LocalDate.of(2021, 11, 1), listaVaciaItems);
	}
	
	@Test
	void testCostoFinal() {
		assertEquals(0, sinItems.getCostoFinal());
		assertEquals(12180, conItems.getCostoFinal());
	}
}
