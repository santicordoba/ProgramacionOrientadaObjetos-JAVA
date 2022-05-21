package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nombre;
	private String direccion;
	private Integer numero;
	private List<Llamada> llamadas;
	private List<Factura> facturas;
	
	public Cliente(String nombre, String direccion, Integer numero) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setNumero(numero);
		this.llamadas= new ArrayList<Llamada>();
		this.facturas= new ArrayList<Factura>();
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
	
	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public List<Llamada> getLlamadas() {
		return this.llamadas;
	}
	

	public Llamada hacerLlamada(Integer numeroDestino, LocalDate fecha, LocalTime hora, double duracion) {
		Llamada llamada= new LlamadaLocal(this.getNumero(), numeroDestino, fecha, hora, duracion);
		this.getLlamadas().add(llamada);
		return llamada;
	}
	

	public Llamada hacerLlamada(Integer numeroDestino, LocalDate fecha, LocalTime hora, double duracion, double distancia) {
		Llamada llamada= new LlamadaInterurbana(this.getNumero(), numeroDestino, fecha, hora, duracion, distancia);
		this.getLlamadas().add(llamada);
		return llamada;
	}

	public Llamada hacerLlamada(Integer numeroDestino, LocalDate fecha, LocalTime hora, double duracion, String paisOrigen, String paisDestino) {
		Llamada llamada= new LlamadaInternacional(this.getNumero(), numeroDestino, fecha, hora, duracion, paisOrigen, paisDestino);
		this.getLlamadas().add(llamada);
		return llamada;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}
	
	public List<Llamada> llamadasEnPeriodo(DateLapse periodo){
		List<Llamada> lista= this.getLlamadas().stream().filter(llamada -> periodo.includesDate(llamada.getFecha())).toList();
		return lista;
	}
	
	public double costoEnPeriodo(DateLapse periodo) {
		return (this.llamadasEnPeriodo(periodo).stream().mapToDouble(llamada -> llamada.costo()).sum());
	}
	
	public void agregarFactura(Factura factura) {
		this.getFacturas().add(factura);
	}
	
}
