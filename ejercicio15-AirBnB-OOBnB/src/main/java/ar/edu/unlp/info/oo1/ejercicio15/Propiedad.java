package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioPorNoche;
	private String direccion;
	private Usuario propietario;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion, double precioPorNoche, String direccion, Usuario propietario) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setPrecioPorNoche(precioPorNoche);
		this.setDireccion(direccion);
		this.setPropietario(propietario);
		this.reservas= new ArrayList<Reserva>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getPropietario() {
		return this.propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public Boolean libre(DateLapse periodo){
		if (this.getReservas().stream().filter(res -> res.getPeriodo().overlaps(periodo) == true).count() == 0) {
			return true;
		}
		return false;
	}

	public double calcularIngresosPropiedadEn(DateLapse periodo) {
		return this.getReservas().stream().filter(res -> res.getPeriodo().overlaps(periodo)).mapToDouble(Reserva::valor).sum();
	}
}
