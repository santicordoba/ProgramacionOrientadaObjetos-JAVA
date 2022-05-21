package ar.edu.unlp.info.oo1.ejercicio11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inversor {

	private String nombre;
	List<Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.setNombre(nombre);
		this.inversiones= new ArrayList<Inversion>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarInversion(Inversion i) {
		this.inversiones.add(i);
	}

	public double valorActual() {
		double valorTotal = this.inversiones.stream().mapToDouble(Inversion::valorActual).sum();
		return valorTotal;
	}
	
	public static void main(String[] parametros){
		Inversor inversor= new Inversor("Santi");
		Inversion plazo1= new PlazoFijo(LocalDate.of(2021, 10, 10), 200.0, 2.0);
		Inversion plazo2= new PlazoFijo(LocalDate.of(2021, 10, 1), 1000.0, 2.0);
		Inversion accion= new InversionEnAcciones("BNB", 1, 450.0);
		inversor.agregarInversion(plazo1);
		inversor.agregarInversion(plazo2);
		inversor.agregarInversion(accion);
		System.out.println(inversor.valorActual());
	}
	
}
