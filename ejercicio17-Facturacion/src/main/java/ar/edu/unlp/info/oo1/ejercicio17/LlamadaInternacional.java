package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada {
	private String paisOrigen;
	private String paisDestino;
	
	public LlamadaInternacional(Integer numeroOrigen, Integer numeroDestino, LocalDate fecha, LocalTime hora, double duracion, String paisOrigen, String paisDestino) {
		super(numeroOrigen, numeroDestino, fecha, hora, duracion);
		this.setPaisOrigen(paisOrigen);
		this.setPaisDestino(paisDestino);
	}
	
	public String getPaisOrigen() {
		return this.paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public String getPaisDestino() {
		return this.paisDestino;
	}
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}
	
	public double costo() {
		double tarifaDiurna=4;
		double tarifaNocturna=3;
		if(this.getHora().isAfter(LocalTime.of(8 , 00)) && this.getHora().isBefore(LocalTime.of(20 , 00))){
			return this.getDuracion()*tarifaDiurna;
		}
		return this.getDuracion()*tarifaNocturna;
	}

	
	

}
