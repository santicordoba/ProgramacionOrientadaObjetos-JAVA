package ar.edu.unlp.info.oo1.ejercicio3_v2balanza;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private LocalDate fecha;
	private List<Producto> productos;
	
	public Ticket() {
		this.productos= new ArrayList<Producto>();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public void setProductos(List<Producto> p) {
		this.productos=p;
	}
	
	public int getCantidadDeProductos() {
		return this.getProductos().size();
	}

	public double getPesoTotal() {
		double pesoTotal= this.getProductos().stream().mapToDouble(Producto::getPeso).sum();
		return pesoTotal;
	}

	public double getPrecioTotal() {
		double precioTotal = this.getProductos().stream().mapToDouble(Producto::getPrecio).sum();
		return precioTotal;
	}

	
	public double impuesto() {
		return (this.getPrecioTotal()*0.21);
	}
	
}
