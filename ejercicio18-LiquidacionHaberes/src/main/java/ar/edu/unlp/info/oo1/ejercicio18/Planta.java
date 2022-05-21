package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public class Planta extends Contrato{
	private double sueldoMensual;
	private double montoPorConyuge;
	private double montoPorHijos;
	
	public Planta(Empleado empleado, LocalDate fechaInicio, double sueldo, double montoPorConyuge, double montoPorHijos) {
		super(empleado, fechaInicio);
		this.setSueldoMensual(sueldo);
		this.setMontoPorConyuge(montoPorConyuge);
		this.setMontoPorHijos(montoPorHijos);
	}
	
	public double getSueldoMensual() {
		return sueldoMensual;
	}
	public void setSueldoMensual(double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	public double getMontoPorHijos() {
		return montoPorHijos;
	}
	public void setMontoPorHijos(double montoPorHijos) {
		this.montoPorHijos = montoPorHijos;
	}
	public double getMontoPorConyuge() {
		return montoPorConyuge;
	}
	public void setMontoPorConyuge(double montoPorConyuge) {
		this.montoPorConyuge = montoPorConyuge;
	}

	public double montoBasico() {
		return this.getSueldoMensual()+this.getMontoPorConyuge()+this.getMontoPorHijos();
	}
}
