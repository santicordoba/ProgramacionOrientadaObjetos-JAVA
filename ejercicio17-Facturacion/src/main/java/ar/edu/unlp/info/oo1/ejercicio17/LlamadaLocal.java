package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaLocal extends Llamada {

	public LlamadaLocal(Integer numeroOrigen, Integer numeroDestino, LocalDate fecha, LocalTime hora, double duracion) {
		super(numeroOrigen, numeroDestino, fecha, hora, duracion);
	}
	
	public double costo() {
		return this.getDuracion()*1;
	}

}
