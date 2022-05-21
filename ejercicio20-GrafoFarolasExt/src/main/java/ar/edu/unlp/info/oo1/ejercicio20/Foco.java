package ar.edu.unlp.info.oo1.ejercicio20;

public class Foco {
	private String fabricante;
	private Integer cantMaximosCiclos;
	private Integer cantCiclos;
	
	public Foco (String fabricante, Integer cantMaximosCiclos) {
		this.setFabricante(fabricante);
		this.setCantMaximosCiclos(cantMaximosCiclos);
		this.setCantCiclos(0);
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getCantMaximosCiclos() {
		return cantMaximosCiclos;
	}

	public void setCantMaximosCiclos(Integer cantMaximosCiclos) {
		this.cantMaximosCiclos = cantMaximosCiclos;
	}

	public Integer getCantCiclos() {
		return cantCiclos;
	}

	public void setCantCiclos(Integer cantCiclos) {
		this.cantCiclos = cantCiclos;
	}

	public void contarUso() {
		this.setCantCiclos(this.getCantCiclos()+1);		
	}

	public Boolean vencido() {
		if(this.getCantCiclos()>=this.getCantMaximosCiclos()) {
			return true;
		}
		return false;
	}

}
