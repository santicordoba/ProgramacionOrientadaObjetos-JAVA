package ar.edu.unlp.info.oo1.ejercicio19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaMercadoTest {
	private SistemaMercado empresa;
	private Pedido pedido;
	private Pedido pedido2;
	private Pedido pedido3;
	private Pedido pedido4;
	private Producto producto;
	private Usuario vendedor;
	private Usuario vendedor2;
	private Usuario cliente;
	private MetodoPago contado;
	private MetodoPago cuotas;
	private MetodoEnvio comercio;
	private MetodoEnvio correo;
	private MetodoEnvio domicilio;
	
	@BeforeEach
	void setUp() {
		empresa= new SistemaMercado();
		contado= new Contado();
		cuotas= new Cuotas();
		comercio= new RetiroComercio();
		correo= new RetiroSucursalCorreo();
		domicilio= new Domicilio();
		vendedor= new Usuario("MercadoLibre", "CABA");
		vendedor= empresa.agregarUsuario("MercadoLibre", "CABA");
		vendedor2= empresa.agregarUsuario("NewTon", "CABA");
		cliente= empresa.agregarUsuario("El boludo de Santiago", "La Plata");
		producto= empresa.ponerUnProductoEnVenta("Monitor", "Es medio trucho", 20000.0, 20, vendedor2);
		empresa.ponerUnProductoEnVenta("Monitor", "Safaroli", 25000.0, 20, vendedor);
		pedido= empresa.crearPedido(cliente, producto, 1, contado, comercio);
	}
	
	@Test
	void testAltaUsuarios() {
		assertEquals(3, empresa.getUsuarios().size());
	}
	
	@Test
	void buscarVendedor() {
		assertEquals(vendedor, empresa.buscarVendedor("MercadoLibre"));
	}
	
	@Test
	void testCrearPedidos() {
		assertNotNull(empresa.crearPedido(cliente, producto, 1, contado, comercio));
	}
	
	@Test
	void testBuscarCliente() {
		assertEquals(cliente, empresa.buscarCliente("El boludo de Santiago"));
	}
	
	@Test
	void testBuscarProducto() {
		List<Producto> lista= empresa.buscarProducto("Monitor");
		assertEquals(2, lista.size());
	}
	
	@Test
	void testCrearUnPedido() {
		assertNotNull(empresa.crearPedido(cliente, producto, 1, contado, comercio));
	}
	
	@Test
	void testCalcularCosto() {
		assertEquals(20000, empresa.calcularCostoTotal(pedido));
	}

}
