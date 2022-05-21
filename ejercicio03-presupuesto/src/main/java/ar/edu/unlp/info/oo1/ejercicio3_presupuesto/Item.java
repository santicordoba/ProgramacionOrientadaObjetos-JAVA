package ar.edu.unlp.info.oo1.ejercicio3_presupuesto;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item detalle(String detalle) {
		this.detalle=detalle;
		return this;
	}
	
	public String getDetalle() {
		return this.detalle;
	}
	
	public Item cantidad(int cant) {
		this.cantidad=cant;
		return this;
	}
	
	public int getCantidad () {
		return this.cantidad;
	}
	
	public Item costoUnitario (double costo) {
		this.costoUnitario=costo;
		return this;
	}
	
	public double getCostoUnitario () {
		return this.costoUnitario;
	}
	
	public double costo() {
		return this.getCantidad()*this.costoUnitario;
	}
}
