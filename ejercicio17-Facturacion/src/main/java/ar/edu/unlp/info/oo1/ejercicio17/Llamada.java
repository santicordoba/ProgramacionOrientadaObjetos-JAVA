package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Llamada {
	private LocalDate fecha;
	private LocalTime hora;
	private double duracion;
	private Integer numeroOrigen;
	private Integer numeroDestino;
	
	public Llamada(Integer numeroOrigen, Integer numeroDestino, LocalDate fecha, LocalTime hora, double duracion) {
		this.setNumeroOrigen(numeroOrigen);
		this.setNumeroDestino(numeroDestino);
		this.setFecha(fecha);
		this.setDuracion(duracion);
		this.setHora(hora);
	}

	public LocalDate getFecha() {
		return this.fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getDuracion() {
		return this.duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public Integer getNumeroOrigen() {
		return this.numeroOrigen;
	}
	public void setNumeroOrigen(Integer numeroOrigen) {
		this.numeroOrigen = numeroOrigen;
	}
	public Integer getNumeroDestino() {
		return this.numeroDestino;
	}
	public void setNumeroDestino(Integer numeroDestino) {
		this.numeroDestino = numeroDestino;
	}

	public LocalTime getHora() {
		return this.hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public abstract double costo();
}
