package ar.edu.unlp.info.oo1.ejercicio19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
	private Pedido pedido;
	private Pedido pedido2;
	private Pedido pedido3;
	private Pedido pedido4;
	private Producto producto;
	private Usuario vendedor;
	private Usuario cliente;
	private MetodoPago contado;
	private MetodoPago cuotas;
	private MetodoEnvio comercio;
	private MetodoEnvio correo;
	private MetodoEnvio domicilio;
	
	@BeforeEach
	void setUp() {
		contado= new Contado();
		cuotas= new Cuotas();
		comercio= new RetiroComercio();
		correo= new RetiroSucursalCorreo();
		domicilio= new Domicilio();
		vendedor= new Usuario("MercadoLibre", "CABA");
		cliente= new Usuario("El boludo de Santiago", "La Plata");
		producto= new Producto("Monitor", "Es medio trucho", 20000.0, 20, vendedor);
		pedido= new Pedido(cliente, producto, 1, contado, comercio);
		pedido2= new Pedido(cliente, producto, 2, contado, correo);
		pedido3= new Pedido(cliente, producto, 1, cuotas, domicilio);
	}
	
	@Test
	void testCosto() {
		assertEquals(20000.0, pedido.costo());
		assertEquals(40050.0, pedido2.costo());
		assertEquals(24120.0, pedido3.costo());
	}
}
