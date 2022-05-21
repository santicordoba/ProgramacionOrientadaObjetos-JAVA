package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInterurbana extends Llamada {
	private double distancia;

	public LlamadaInterurbana(Integer numeroOrigen, Integer numeroDestino, LocalDate fecha, LocalTime hora, double duracion, double distancia) {
		super(numeroOrigen, numeroDestino, fecha, hora, duracion);
		this.setDistancia(distancia);
	}

	public double getDistancia() {
		return this.distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public double costo() {
		double costoConexion=5;
		if(this.getDistancia()<100) {
			return (this.getDuracion()*2)+costoConexion;
		} else {
			if(this.getDistancia()>100 && this.getDistancia()<500) {
				return (this.getDuracion()*2.5)+costoConexion;
			}
		}
		return (this.getDuracion()*3)+costoConexion;
	}


}
