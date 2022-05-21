package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String unNombre) {
		this.setNombre(unNombre);
		this.emails= new ArrayList<Email>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarEmail(Email e) {
		this.emails.add(e);
	}

	public List<Email> getEmails() {
		return this.emails;
	}
	
	public void eliminarEmail(Email email) {
		this.getEmails().remove(email);
	}
	
	public List<Email> obtenerEmailConTexto(String unTexto) {
		List<Email> temp= this.getEmails().stream().filter(e -> e.getTitulo() == unTexto || e.getCuerpo() == unTexto).collect(Collectors.toList());
		return temp;
	}

	public int tamanio() {
		Integer total= this.getEmails().stream().mapToInt(Email::tamanio).sum();
		return total;
	}
	
	public static void main(String[] parametros){
		Carpeta c1;
		Carpeta c2;
		Email em1;
		Email em2;
		Email em3;
		Archivo ar1;
		c1= new Carpeta("Inbox");
		c2= new Carpeta("Spam");
		em1= new Email("Hola","Juan Carlos");
		em2= new Email("Como estas", "Chupapija");
		em3= new Email("Pago", "Pago");
		ar1= new Archivo("Presentacion");
		em1.agregarAdjunto(ar1);
		c1.agregarEmail(em1);
		c2.agregarEmail(em2);
		c1.agregarEmail(em3);
		System.out.println(c1.tamanio());
		System.out.println(c2.tamanio());
	}

}
