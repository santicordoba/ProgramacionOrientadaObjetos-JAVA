package ar.edu.unlp.info.oo1.ejercicio13;

public class Archivo {
	private String nombre;
	private int tamanio;
	
	public Archivo(String nombre) {
		this.setNombre(nombre);
		this.setTamanio(nombre.length());
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTamanio() {
		return this.tamanio;
	}
	
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
}
