package ar.edu.unlp.info.oo1.parcialFarolas;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private Boolean estado;
	private List<Farola> vecinas;
	private LightSensor sensor;
	
	public Farola(Boolean estado) {
		this.vecinas= new ArrayList<Farola>();
		this.estado=false;
		this.sensor= new LightSensor(estado);
	}
	
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public List<Farola> getVecinas() {
		return vecinas;
	}
	
	public void agregarVecina(Farola otraFarola) {
		this.vecinas.add(otraFarola);
		otraFarola.vecinas.add(this);
	}
	
	public LightSensor getSensor() {
		return sensor;
	}
	
	public Boolean redEncendida() {
		List<Boolean> listaEstado= this.getVecinas().stream().map(farola -> farola.isOn()).toList();
		if(listaEstado.contains(false)) {
			return false;
		} else {
			return true;
		}
	}
	
	public Boolean estadoNocturno() {
		List<Boolean> listaEstado= this.getVecinas().stream().map(farola -> farola.sensor.isDark()).toList();
		if(listaEstado.contains(true)) {
			return true;
		}
		return false;
	}
	
	public void encender() {
		if(this.getEstado()==false) {
			this.estado=true;
			this.getVecinas().stream().forEach(vecina -> vecina.encender());
		}
	}
	
	public void apagar() {
		if(this.getEstado()==true){
			this.setEstado(false);
			this.getVecinas().stream().forEach(vecina -> vecina.apagar());
		}
	}
	
	public Boolean isOn() {
		return this.getEstado();
	}

	public static void main(String[] parametros){
		Farola f1= new Farola(true);
		Farola f2= new Farola(true);
		f1.agregarVecina(f2);
		f1.estadoNocturno();
	}
	
	

}
