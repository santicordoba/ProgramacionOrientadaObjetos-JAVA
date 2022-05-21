package ar.edu.unlp.info.oo1.ejercicio11;

public class InversionEnAcciones implements Inversion {
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		this.setCantidad(cantidad);
		this.setNombre(nombre);
		this.setValorUnitario(valorUnitario);
	}

	@Override
	public double valorActual() {
		return this.getValorUnitario()*this.getCantidad();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double unValor) {
		this.valorUnitario = unValor;
	}

}
