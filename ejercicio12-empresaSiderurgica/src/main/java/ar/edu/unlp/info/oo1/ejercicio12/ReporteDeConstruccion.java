package ar.edu.unlp.info.oo1.ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		this.piezas= new ArrayList<Pieza>();
	}
	
	public void agregarPieza(Pieza p) {
		this.piezas.add(p);
	}
	
	public List<Pieza> getPiezas(){
		return this.piezas;
	}
	
	public double volumenDeMaterial(String material) {
		//Recibe como parámetro un nombre de material

		//Retorna la suma de los volúmenes de todas las 
		//piezas hechas en ese material
		double total= this.getPiezas().stream().filter(mat -> mat.getMaterial() == material).mapToDouble(Pieza::getVolumen).sum();
		return total;
	}
	
	public double superficieDeColor(String color) {
		//"Recibe como parámetro un color 
		// Retorna la suma de las superficies externas de todas las piezas pintadas con ese color".
		double total= this.getPiezas().stream().filter(mat -> mat.getColor() == color).mapToDouble(Pieza::getSuperficie).sum();
		return total;
	}
	
	
	public static void main(String[] parametros){
		ReporteDeConstruccion reporte;
		Pieza cil1;
		Pieza cil2;
		Pieza esf1;
		Pieza esf2;
		Pieza pris1;
		Pieza pris2;
		reporte= new ReporteDeConstruccion();
		cil1 = new Cilindro(2, 5, "Hierro", "Rojo");
    	cil2 = new Cilindro(2, 10, "Hierro", "Verde");
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
		System.out.println(reporte.superficieDeColor("Rojo"));
		System.out.println(reporte.volumenDeMaterial("Hierro"));
	}
	
	
}
