package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

public class Factura {
	private DateLapse periodo;
	private LocalDate fechaFacturacion;
	private double monto;
	
	public Factura(DateLapse periodo, LocalDate now, double monto) {
		this.setPeriodo(periodo);
		this.setFechaFacturacion(fechaFacturacion);
		this.setMonto(monto);
	}
	
	public LocalDate getFechaFacturacion() {
		return fechaFacturacion;
	}
	public void setFechaFacturacion(LocalDate fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}


	public DateLapse getPeriodo() {
		return periodo;
	}


	public void setPeriodo(DateLapse periodo) {
		this.periodo = periodo;
	}
	
	
}
