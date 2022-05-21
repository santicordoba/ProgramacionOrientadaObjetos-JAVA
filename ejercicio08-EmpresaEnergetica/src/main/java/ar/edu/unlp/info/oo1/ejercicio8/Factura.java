package ar.edu.unlp.info.oo1.ejercicio8;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(double activa, double descuento, Usuario usuario) {
		this.setMontoEnergiaActiva(activa);
		this.setDescuento(descuento);
		this.setUsuario(usuario);
		this.setFecha(LocalDate.now());
	}

	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}
	
	public void setMontoEnergiaActiva(double montoEnergiaActiva) {
		this.montoEnergiaActiva = montoEnergiaActiva;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public void setUsuario(Usuario unUsuario) {
		this.usuario=unUsuario;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public double montoTotal() {
		return (this.getMontoEnergiaActiva())-(this.getMontoEnergiaActiva()*this.getDescuento()/100);
	}
}
