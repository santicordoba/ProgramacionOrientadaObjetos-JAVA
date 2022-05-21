package ar.edu.unlp.info.oo1.ejercicio11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class PlazoFijo implements Inversion {

	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fecha, double unMonto, double interesDiario) {
		this.setFechaDeConstitucion(fecha);
		this.setMontoDepositado(unMonto);
		this.setPorcentajeDeInteresDiario(interesDiario);
	}
	
	@Override
	public double valorActual() {
		LocalDate hoy= LocalDate.now();
		long dias= ChronoUnit.DAYS.between(this.getFechaDeConstitucion(), hoy);
		return (this.getMontoDepositado()+(this.getPorcentajeDeInteresDiario()*this.getMontoDepositado())/100*dias);
	}

	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}

	public void setFechaDeConstitucion(LocalDate fechaDeConstitucion) {
		this.fechaDeConstitucion = fechaDeConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public void setMontoDepositado(double unMonto) {
		this.montoDepositado = unMonto;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}

	public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public static void main(String[] parametros){
		PlazoFijo plazo= new PlazoFijo(LocalDate.of(2021, 10, 10), 200.0, 2.0);
		LocalDate hoy= LocalDate.now();
		System.out.println(ChronoUnit.DAYS.between(plazo.getFechaDeConstitucion(), hoy));
		System.out.println(plazo.valorActual());
	}


	
}


