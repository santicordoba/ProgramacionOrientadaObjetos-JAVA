package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public abstract class Contrato {
	private LocalDate fechaInicio;
	private Empleado empleado;
	
	public Contrato(Empleado empleado, LocalDate fechaInicio) {
		this.setEmpleado(empleado);
		this.setFechaInicio(fechaInicio);
	}
	
	public Contrato() {
		this.setFechaInicio(fechaInicio);
		this.setEmpleado(empleado);
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Boolean activo() {
		return true;
	}
	
	public abstract double montoBasico();
}
