package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.ArrayList;
import java.util.List;




public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double valor) {
		this.setPrecioKWH(valor);
		this.usuarios= new ArrayList<Usuario>();
	}

	public double getPrecioKWh() {
		return this.precioKWh;
	}
	
	public void setPrecioKWH(double precio) {
		this.precioKWh=precio;
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public void agregarUsuario(Usuario u) {
		this.getUsuarios().add(u);
	}
	
	public List<Factura> facturar() {
		List<Factura> facturas = new ArrayList<Factura>();;
		//facturas.add(this.getUsuarios().stream().forEach(usuario -> usuario.facturarEnBaseA(this.getPrecioKWh())));

		for(int i=0; i< this.getUsuarios().size(); i++) {
			facturas.add(this.getUsuarios().get(i).facturarEnBaseA(this.getPrecioKWh()));
		}
		return facturas;
	}

	public double consumoTotalActiva() {
		double activa;
		activa= this.getUsuarios().stream().mapToDouble(Usuario::ultimoConsumoActiva).sum();
		return activa;
	}

}
