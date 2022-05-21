package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario(){
		this.facturas= new ArrayList<Factura>(); 
		this.consumos= new ArrayList<Consumo>();
	}
	
	public Usuario(String nombre, String domicilio) {
		this.setNombre(nombre);
		this.setDomicilio(domicilio);
		this.facturas= new ArrayList<Factura>(); 
		this.consumos= new ArrayList<Consumo>();		
	}

	public void setDomicilio(String unDomicilio) {
		this.domicilio=unDomicilio;
	}
	
	public String getDomicilio() {
		return this.domicilio;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String unNombre) {
		this.nombre=unNombre;
	}
	
	public List<Consumo> getConsumos(){
		return this.consumos;
	}
	
	public void agregarMedicion(Consumo unConsumo) {
		this.getConsumos().add(unConsumo);
	}
	
	public Consumo ultimoConsumo() {
		return this.getConsumos().stream().max(Comparator.comparing(Consumo::getFecha)).get();
	}
	
	public double ultimoConsumoActiva() {
		return this.getConsumos().stream().max(Comparator.comparing(Consumo::getFecha)).get().getConsumoEnergiaActiva();
	}
	
	public double ultimoConsumoReactiva() {
		return this.getConsumos().stream().max(Comparator.comparing(Consumo::getFecha)).get().getConsumoEnergiaReactiva();
	}
	
	public List<Factura> facturas(){
		return this.facturas;
	}

	public Factura facturarEnBaseA(double precioKWh) {
		Factura f;
		double precioActiva= this.ultimoConsumoActiva()*precioKWh;
		double fpe= (this.ultimoConsumoActiva())/ Math.sqrt((Math.pow(this.ultimoConsumoActiva(),2)+Math.pow(this.ultimoConsumoReactiva(),2)));
		if(fpe>0.8) {
			f= new Factura(precioActiva,10,this);
		} else {
			f= new Factura(precioActiva,0,this);
		}	
		return f;
	}
}
