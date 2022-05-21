package ar.edu.unlp.info.oo1.ejercicio17;

public class Juridico extends Cliente {
	private Integer cuit;
	private String tipo;
	
	public Juridico(String nombre, String direccion, Integer numero, Integer cuit, String tipo) {
		super(nombre, direccion, numero);
		this.setCuit(cuit);
		this.setTipo(tipo);
	}
	
	public Integer getCuit() {
		return this.cuit;
	}
	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
