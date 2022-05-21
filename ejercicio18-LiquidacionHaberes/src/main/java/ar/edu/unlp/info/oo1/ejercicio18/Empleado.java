package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Empleado {
	private String nombre;
	private String apellido;
	private String cuil;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCuil(cuil);
		this.setFechaNacimiento(fechaNacimiento);
		this.setFechaIngreso(fechaIngreso);
		this.contratos= new ArrayList<Contrato>();
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	public void agregarContrato(Contrato contrato) {
		this.getContratos().add(contrato);
	}
	
	public Boolean contratoVencido() {
		if(this.getContratos().stream().filter(con -> con.activo()).count() == 0){
			return true;
		}
		return false;
	}
	
	public Integer antiguedad() {
		Period period= Period.between(this.getFechaIngreso(), LocalDate.now());
		return period.getYears();
	}
	
	public double sueldo() {
		Contrato contratoActivo= this.getContratos().stream().filter(con -> con.activo()).findFirst().orElse(null);
		if(this.antiguedad()>=5 && this.antiguedad()<10) {
			return contratoActivo.montoBasico()*1.3;
		} else {
			if(this.antiguedad()>=10 && this.antiguedad()<15) {
				return contratoActivo.montoBasico()*1.5;
			} else {
				if(this.antiguedad()>=15 && this.antiguedad()<20) {
					return contratoActivo.montoBasico()*1.7;
				} else {
					if(this.antiguedad()>20) {
						return contratoActivo.montoBasico()*2;
					}
				}
			}
		}
		return contratoActivo.montoBasico();
	}
}
