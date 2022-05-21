package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.time.LocalDate;

public class Balanza {
	private int cantidadDeproductos;
	private double precioTotal;
	private double pesoTotal;
	
	public int getCantidadDeProductos() {
		return this.cantidadDeproductos;
	}
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public Balanza ponerEnCero() {
		this.pesoTotal=0;
		this.precioTotal=0;
		this.cantidadDeproductos=0;
		return this;
	}
	
	public Balanza agregarProducto(Producto p) {
		this.cantidadDeproductos= this.getCantidadDeProductos()+1;
		this.precioTotal=this.precioTotal+(p.getPeso()*p.getPrecioPorKilo());
		this.pesoTotal=this.pesoTotal+p.getPeso();
		return this;
	}
	
	public Ticket emitirTicket() {
		Ticket t= new Ticket();
		t.setFecha(LocalDate.now());
		t.setCantidadDeProductos(this.getCantidadDeProductos());
		t.setPesoTotal(this.getPesoTotal());
		t.setPrecioTotal(this.getPrecioTotal()+t.impuesto());
		return t;
	}
}
