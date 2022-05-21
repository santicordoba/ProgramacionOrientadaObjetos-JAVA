package ar.edu.unlp.info.oo1.ejercicio20;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FarolaTest {
	 private Farola farolaUno;
	  private Farola farolaDos;
	  private Farola farolaTres;
	  private Farola farolaCuatro;
	  
	  

	  @BeforeEach
	  void setUp() throws Exception {
	    this.farolaUno = new Farola("Osram", 1);
	    this.farolaDos = new Farola("Philips", 1);
	    this.farolaTres = new Farola("Carrefour", 1);
	    this.farolaCuatro = new Farola("Cica", 1);

	  }

	  @Test
	  void testConstructor() {
	    assertFalse(farolaUno.getEstado(), "La farolaUno no está apagada");
	    assertFalse(farolaUno.getEstado(), "La farolaUno no está apagada");
	    assertTrue(farolaUno.getNeighbors().isEmpty(), "La farolaUno no debería tener vecinos");
	  }
	 
	  @Test
	  void testPairWithNeighbor() {
	    farolaUno.pairWithNeighbor(farolaDos);
	    assertTrue(farolaUno.getNeighbors().contains(farolaDos));
	    assertTrue(farolaDos.getNeighbors().contains(farolaUno));
	  }
	  
	  @Test
	  void testTurnOnAndOff() {
	    farolaUno.pairWithNeighbor(farolaDos);
	    farolaDos.pairWithNeighbor(farolaTres);
	    farolaDos.pairWithNeighbor(farolaCuatro);
	    farolaUno.turnOn();
	    assertTrue(farolaUno.getEstado());
	    assertTrue(farolaDos.getEstado());
	    assertTrue(farolaTres.getEstado());
	    assertTrue(farolaCuatro.getEstado());
	    farolaUno.turnOff();
	    assertFalse(farolaUno.getEstado());
	    assertFalse(farolaDos.getEstado());

	    farolaDos.turnOn();
	    assertTrue(farolaUno.getEstado());
	    assertTrue(farolaDos.getEstado());
	    farolaDos.turnOff();
	    assertFalse(farolaUno.getEstado());
	    assertFalse(farolaDos.getEstado());
	    
	  }
	  
	  @Test
	  void testFarolasConFocosVencidos(){
		  farolaUno.pairWithNeighbor(farolaDos);
		  farolaDos.pairWithNeighbor(farolaTres);
		  farolaTres.pairWithNeighbor(farolaCuatro);
		  assertEquals(0, farolaUno.farolasConFocosVencidos().size());
		  farolaUno.turnOn();
		  farolaUno.turnOff();
		  farolaUno.turnOn();
		  farolaUno.turnOff();
		  farolaUno.turnOn();
		  assertEquals(3, farolaUno.farolasConFocosVencidos().size());
	  }
	}	