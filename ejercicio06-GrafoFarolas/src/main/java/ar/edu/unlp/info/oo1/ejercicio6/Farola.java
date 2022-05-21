package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.ArrayList;
import java.util.List;





public class Farola {
	private Boolean estado;
	private List<Farola> neigbors;
	
	
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola () {
		this.estado=false;
		this.neigbors=new ArrayList<Farola>();
	}
	/*
	* Obtiene el estado de una farola
	*/	
	private boolean getEstado() {
		return this.estado;
	}

	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	public void pairWithNeighbor(Farola otraFarola) {
		this.getNeighbors().add(otraFarola);
		otraFarola.getNeighbors().add(this);
	}
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors(){
		return this.neigbors;
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if(this.getEstado()==false) {
			this.estado=true;
			this.getNeighbors().stream().forEach(neighbor -> neighbor.turnOn());
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if(this.getEstado()==true) {
			this.estado=false;

			this.getNeighbors().stream().forEach(neighbor -> neighbor.turnOff());
		}		
	}



	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return this.getEstado();
	}


}
