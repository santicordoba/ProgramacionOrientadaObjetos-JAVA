package ar.edu.unlp.info.oo1.ejercicio17;

public class Individuo extends Cliente {
	private Integer dni;

	public Individuo(String nombre, String direccion, Integer numero, Integer dni) {
		super(nombre, direccion, numero);
		this.setDni(dni);
	}

	public Integer getDni() {
		return this.dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public double costoEnPeriodo(DateLapse periodo) {
		return (this.llamadasEnPeriodo(periodo).stream().mapToDouble(llamada -> llamada.costo()).sum())*0.9;
	}

}
