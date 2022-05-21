package ar.edu.unlp.info.oo1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class CilindroTest {
	protected Cilindro cil1;
	protected Cilindro cil2;

    private void inicializarCilindros() {
    	cil1= new Cilindro(2, 5, "Hierro", "Rojo");
    	cil2= new Cilindro(2, 10, "Madera", "Verde");
   	
    }
    
    @BeforeEach
    void setUp() {
    	this.inicializarCilindros();
    }
    
    @Test
    public void testGetVolumen() {
    	assertEquals(63, Math.round(cil1.getVolumen()));
    	assertEquals(126, Math.round(cil2.getVolumen()));
    }
    
    @Test
    void testGetPerimetro() {
    	assertEquals(88, Math.round(cil1.getSuperficie()));
    	assertEquals(151, Math.round(cil2.getSuperficie()));
    }
}
