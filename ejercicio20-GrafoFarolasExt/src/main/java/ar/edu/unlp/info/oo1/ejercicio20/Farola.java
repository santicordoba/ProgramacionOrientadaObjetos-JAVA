package ar.edu.unlp.info.oo1.ejercicio20;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private List<Farola> farolasVecinas;
	private Foco foco;
	private Boolean estado;
	
	public Farola(String fabricante, int cantidadDeCiclos) {
		Foco f= new Foco(fabricante, cantidadDeCiclos);
		this.farolasVecinas= new ArrayList<Farola>();
		this.setFoco(f);
		this.setEstado(false);
	}
	
	public Foco getFoco() {
		return foco;
	}
	public void setFoco(Foco foco) {
		this.foco = foco;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public List<Farola> getNeighbors() {
		return farolasVecinas;
	}
	
	public void agregarVecina(Farola vecina) {
		this.getNeighbors().add(vecina);
	}
	
	public void pairWithNeighbor(Farola otraFarola) {
		this.agregarVecina(otraFarola);
		otraFarola.agregarVecina(this);
	}
	
	public void turnOn() {
		if(this.getEstado() == false) {
			this.setEstado(true);
			this.getFoco().contarUso();
			this.getNeighbors().stream().forEach(farola -> farola.turnOn());
		}
	}
	
	public void turnOff() {
		if(this.getEstado() == true) {
			this.setEstado(false);
			this.getNeighbors().forEach(farola -> farola.turnOff());
		}
	}
	
	public Boolean vencida() {
		return this.getFoco().vencido();
	}
	
	public List<Farola> farolasConFocosVencidos(){
		List<Farola> lista= this.getNeighbors().stream().filter(far -> far.vencida() == true).toList();
		return lista;
	}

	public static void main(String[] parametros){
		Farola f1= new Farola("Caca0", 1);
		Farola f2= new Farola("Caca1", 1);
		f1.pairWithNeighbor(f2);
		f1.turnOn();
		f1.turnOff();
		f1.turnOn();
		if(f1.vencida()) {
			System.out.println("Esta verga se vencio");
		} else {
			System.out.println(f1.getFoco().getCantCiclos());
		}
		List<Farola> lista=f1.farolasConFocosVencidos();
		System.out.println(lista.size());
		System.out.println(lista.get(0).getFoco().getFabricante());
	}
	
	

}
