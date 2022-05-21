package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.setCuerpo(cuerpo);
		this.setTitulo(titulo);
		this.adjuntos= new ArrayList<Archivo>();
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCuerpo() {
		return this.cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public List<Archivo> getAdjuntos() {
		return adjuntos;
	}
	public void agregarAdjunto(Archivo archivo) {
		this.adjuntos.add(archivo);
	}

	public int tamanio() {
		Integer texto= this.getTitulo().length() + this.getCuerpo().length();
		Integer archivos= this.getAdjuntos().stream().mapToInt(a -> a.getTamanio()).sum();
		return texto + archivos;
	}


}
