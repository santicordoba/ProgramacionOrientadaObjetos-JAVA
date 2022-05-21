package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaTelefonia {
	private List<Integer> telefonosDisponibles;
	private List<Cliente> clientes;
	
	public SistemaTelefonia() {
		this.clientes= new ArrayList<Cliente>();
		this.telefonosDisponibles= new ArrayList<Integer>();
	}
	
	public List<Integer> getTelefonosDisponibles() {
		return this.telefonosDisponibles;
	}
	
	public void agregarNumero(Integer nuevoNumero) {
		this.getTelefonosDisponibles().add(nuevoNumero);
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public Cliente altaCliente(String nombre, String direccion, Integer dni) {
		Cliente cliente= new Individuo(nombre, direccion, dni, this.getTelefonosDisponibles().get(0));
		this.getTelefonosDisponibles().remove(0);
		this.getClientes().add(cliente);
		return cliente;
	}
	
	public Cliente altaCliente(String nombre, String direccion, Integer cuit, String tipo) {
		Cliente cliente= new Juridico(nombre, direccion, this.getTelefonosDisponibles().get(0), cuit, tipo);
		this.getTelefonosDisponibles().remove(0);
		this.getClientes().add(cliente);
		return cliente;
	}
	
	public Factura facturar(Cliente cliente, DateLapse periodo) {
		Factura factura= new Factura(periodo, LocalDate.now(), cliente.costoEnPeriodo(periodo));
		cliente.agregarFactura(factura);
		return factura;
	}
}
