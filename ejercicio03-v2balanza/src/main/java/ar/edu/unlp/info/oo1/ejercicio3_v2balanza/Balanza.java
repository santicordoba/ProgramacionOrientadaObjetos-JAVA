package ar.edu.unlp.info.oo1.ejercicio3_v2balanza;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Balanza {
	private List<Producto> productos;
	
	public Balanza() {
		this.productos=  new ArrayList<Producto>();
	}	
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public double getPrecioTotal() {
		double precioTotal = this.productos.stream().mapToDouble(Producto::getPrecio).sum();
		return precioTotal;
	}
	public double getPesoTotal() {
		double pesoTotal = this.productos.stream().mapToDouble(Producto::getPeso).sum();
		return pesoTotal;
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public Balanza ponerEnCero() {
		this.productos.clear();
		return this;
	}
	
	public Balanza agregarProducto(Producto p) {
		this.productos.add(p);
		return this;
	}
	
	public Ticket emitirTicket() {
		Ticket t= new Ticket();
		t.setProductos(this.getProductos());
		t.setFecha(LocalDate.now());
		return t;
	}
}
