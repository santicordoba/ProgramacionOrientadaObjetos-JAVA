package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private List<Producto> productosVenta;
	private List<Pedido> pedidos;
	
	public Usuario(String nombre, String direccion) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.productosVenta= new ArrayList<Producto>();
		this.pedidos= new ArrayList<Pedido>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Producto> getProductos() {
		return this.productosVenta;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void agregarProductoEnVenta(Producto producto) {
		this.getProductos().add(producto);
	}

	public void agregarPedido(Pedido pedido) {
		this.getPedidos().add(pedido);
		
	}
	
	public List<Producto> buscarProductoPorNombre(String nombreProducto){
		List<Producto> lista= this.getProductos().stream().filter(pro -> pro.getNombre() == nombreProducto).toList();
		return lista;
	}
	

}
