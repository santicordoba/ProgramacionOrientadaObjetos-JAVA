package ar.edu.unlp.info.oo1.ejercicio18;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class SistemaDeLiquidacion {
	private List<Empleado> empleados;
	private List<Recibo> recibos;
	
	public SistemaDeLiquidacion() {
		this.empleados= new ArrayList<Empleado>();
		this.recibos= new ArrayList<Recibo>();
	}
	
	public List<Recibo> getRecibos() {
		return recibos;
	}
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	public Empleado altaEmpleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento) {
		Empleado e= new Empleado(nombre, apellido, cuil, fechaNacimiento, LocalDate.now());
		this.getEmpleados().add(e);
		return e;
	}
	
	public Empleado buscarEmpleado(String cuil) {
		Empleado empleado= this.getEmpleados().stream().filter(emp -> emp.getCuil() == cuil).findFirst().orElse(null);
		return empleado;
	}
	
	public void bajaEmpleado(Empleado emp) {
		this.getEmpleados().remove(emp);
	}
	
	public void cargarContrato(Empleado emp, LocalDate fechaInicio, double valorHora, Integer cantHoras, LocalDate fechaFin) {
		Contrato contrato= new PorHoras(emp, fechaInicio, valorHora, cantHoras, fechaFin);
		emp.agregarContrato(contrato);
	}
	
	public void cargarContrato(Empleado emp, LocalDate fechaInicio, double sueldo, double montoPorConyuge, double montoPorHijos) {
		Contrato contrato= new Planta(emp, fechaInicio, sueldo, montoPorConyuge, montoPorHijos);
		emp.agregarContrato(contrato);
	}
	
	public List<Empleado> obtenerEmpleadosContratosVencidos(){
		List<Empleado> lista= this.getEmpleados().stream().filter(emp -> emp.contratoVencido()).toList();
		return lista;
	}
	
	public List<Empleado> obtenerEmpleadosActivos(){
		List<Empleado> lista= this.getEmpleados().stream().filter(emp -> emp.contratoVencido() == false).toList();
		return lista;
	}
	
	public List<Recibo> generarRecibos() {
		List<Empleado> lista= this.obtenerEmpleadosActivos();
		List<Recibo> recibos= new ArrayList<Recibo>();
		for(Empleado empleado: lista) {
			Recibo recibo= new Recibo(empleado.getNombre(), empleado.getApellido(), empleado.getCuil(), empleado.antiguedad(), LocalDate.now(), empleado.sueldo());
			this.getRecibos().add(recibo);
			recibos.add(recibo);
		}
		return recibos;
	}

}
