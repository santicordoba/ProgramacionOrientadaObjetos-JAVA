package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private Integer dni;
	private List<Reserva> reservas;
	private List<Propiedad> propiedades;

	public Usuario(String nombre, String direccion, Integer dni) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setDni(dni);
		this.reservas= new ArrayList<Reserva>();
		this.propiedades= new ArrayList<Propiedad>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getDni() {
		return this.dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public List<Propiedad> getPropiedades() {
		return propiedades;
	}
	
	public List<Reserva> getReservas() {
		return this.reservas;
	}
	

}
