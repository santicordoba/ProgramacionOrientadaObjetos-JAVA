package ar.edu.unlp.info.oo1.ejercicio18;
import java.time.LocalDate;

public class Recibo {
	private String nombre;
	private String apellido;
	private String cuil;
	private double antiguedad;
	private LocalDate fechaGeneracion;
	private  double montoTotal;
	
	public Recibo(String nombre, String apellido, String cuil, Integer antiguedad, LocalDate fechaGeneracion, double montoTotal) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCuil(cuil);
		this.setAntiguedad(antiguedad);
		this.setFechaGeneracion(fechaGeneracion);
		this.setMontoTotal(montoTotal);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public double getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(double antiguedad) {
		this.antiguedad = antiguedad;
	}
	public LocalDate getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(LocalDate fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	
}
