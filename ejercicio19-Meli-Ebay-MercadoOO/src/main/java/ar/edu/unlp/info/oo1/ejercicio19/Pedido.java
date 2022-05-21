package ar.edu.unlp.info.oo1.ejercicio19;

public class Pedido {
	private Usuario cliente;
	private Producto producto;
	private int cantUnidades;
	private MetodoPago metodoPago;
	private MetodoEnvio metodoEnvio;
	

	public Pedido(Usuario cliente, Producto producto, int cantUnidades, MetodoPago metodoPago,
			MetodoEnvio metodoEnvio) {
		this.setCliente(cliente);
		this.setProducto(producto);
		this.setCantUnidades(cantUnidades);
		this.setMetodoPago(metodoPago);
		this.setMetodoEnvio(metodoEnvio);
	}


	public Usuario getCliente() {
		return cliente;
	}


	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantUnidades() {
		return cantUnidades;
	}


	public void setCantUnidades(int cantUnidades) {
		this.cantUnidades = cantUnidades;
	}


	public MetodoPago getMetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}


	public MetodoEnvio getMetodoEnvio() {
		return metodoEnvio;
	}


	public void setMetodoEnvio(MetodoEnvio metodoEnvio) {
		this.metodoEnvio = metodoEnvio;
	}


	public double costo() {
		return ((this.getProducto().getPrecio()*this.getCantUnidades())+this.getMetodoEnvio().costo())*this.getMetodoPago().costo();
	}

	
}
