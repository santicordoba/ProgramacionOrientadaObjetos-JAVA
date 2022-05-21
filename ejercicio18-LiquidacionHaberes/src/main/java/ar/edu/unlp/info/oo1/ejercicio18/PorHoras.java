package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public class PorHoras extends Contrato{
	private double valorHora;
	private double cantHoras;
	private LocalDate fechaFin;
	
	public PorHoras(Empleado empleado, LocalDate fechaInicio, double valorHora, double cantHoras, LocalDate fechaFin) {
		super(empleado, fechaInicio);
		this.setValorHora(valorHora);
		this.setCantHoras(cantHoras);
		this.setFechaFin(fechaFin);
	}
	
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public double getCantHoras() {
		return cantHoras;
	}
	public void setCantHoras(double cantHoras) {
		this.cantHoras = cantHoras;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public Boolean activo() {
		if(this.getFechaFin().isAfter(LocalDate.now())){
			return true;
		}
		return false;
	}
	
	public double montoBasico() {
		return this.getCantHoras()*this.getValorHora();
	}
}
