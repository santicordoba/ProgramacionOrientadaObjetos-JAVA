package ar.edu.unlp.info.oo1.ejercicio3_v2balanza;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}
	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return (this.getPeso()*this.getPrecioPorKilo());
	}
	
}
