package ar.edu.unlp.info.oo1.ejercicio19;

public class Producto {
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private Usuario vendedor;

	public Producto(String nombreProducto, String descripcion, double precio, int stock, Usuario vendedor) {
		this.setNombre(nombreProducto);
		this.setDescripcion(descripcion);
		this.setPrecio(precio);
		this.setStock(stock);
		this.setVendedor(vendedor);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}
	
	

}
