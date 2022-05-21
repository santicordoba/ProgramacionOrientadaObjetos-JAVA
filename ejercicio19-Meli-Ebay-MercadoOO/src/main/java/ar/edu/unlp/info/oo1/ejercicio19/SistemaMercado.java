package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaMercado {
	private List<Usuario> usuarios;
	
	public SistemaMercado() {
		this.usuarios= new ArrayList<Usuario>();
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	public Usuario agregarUsuario(String nombre, String direccion) {
		Usuario u= new Usuario(nombre, direccion);
		this.getUsuarios().add(u);
		return u;
	}
	
	public Usuario buscarVendedor(String nombre){
		Usuario usuario= null;
		usuario= this.getUsuarios().stream().filter(user -> user.getNombre() == nombre).filter(user -> user.getProductos().size() > 0).toList().get(0);
		return usuario;
	}
	
	public List<Producto> buscarProducto(String nombreProducto){
		List<List<Producto>> listaDeLista= this.getUsuarios().stream().
				map(pro -> pro.buscarProductoPorNombre(nombreProducto)).toList();
		List<Producto> lista= listaDeLista.stream().collect(ArrayList::new, List::addAll, List::addAll);
		return lista;
	}
	
	public Usuario buscarCliente(String nombre) {
		Usuario usuario= null;
		usuario= this.getUsuarios().stream().filter(user -> user.getNombre() == nombre).filter(user -> user.getPedidos().size() > 0).toList().get(0);
		return usuario;
	}
	
	public Producto ponerUnProductoEnVenta(String nombreProducto, String descripcion, double precio, int stock, Usuario vendedor) {
		Producto producto= new Producto(nombreProducto, descripcion, precio, stock, vendedor);
		vendedor.agregarProductoEnVenta(producto);
		return producto;
	}
	
	public Pedido crearPedido(Usuario cliente, Producto producto, int cantUnidades, MetodoPago metodoPago, MetodoEnvio metodoEnvio) {
		Pedido pedido= null;
		if(producto.getStock()>=cantUnidades) {
			pedido= new Pedido(cliente, producto, cantUnidades, metodoPago, metodoEnvio);
			producto.setStock(producto.getStock()-cantUnidades);
			cliente.agregarPedido(pedido);
			
		}
		return pedido;
	}
	
	public double calcularCostoTotal(Pedido pedido) {
		return pedido.costo();
	}
}
