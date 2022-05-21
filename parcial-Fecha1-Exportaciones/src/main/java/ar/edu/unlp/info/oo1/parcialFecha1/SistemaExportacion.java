package ar.edu.unlp.info.oo1.parcialFecha1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class SistemaExportacion {
	private List<PedidoExportacion> pedidos;
	private List<FacturaExportacion> facturas;
	
	public SistemaExportacion() {
		this.pedidos=new ArrayList<PedidoExportacion>();
		this.facturas= new ArrayList<FacturaExportacion>();
	}
	
	public List<PedidoExportacion> getPedidos() {
		return pedidos;
	}
	public List<FacturaExportacion> getFacturas() {
		return facturas;
	}
	
	public PedidoExportacion altaPedidoExportacion(String destino, LocalDate fechaExportacion, String nombreEmpresa) {
		PedidoExportacion pedido= new PedidoExportacion(destino, fechaExportacion, nombreEmpresa);
		this.pedidos.add(pedido);
		return pedido;
	}
	
	public void agregarItem(PedidoExportacion pedido, String descripcion, int unidades, double peso, double valorUnidad) {
		Item i= new Bien(descripcion, unidades, peso, valorUnidad);
		pedido.agregar(i);
	}
	
	public void agregarItem(PedidoExportacion pedido, String descripcion, double costoMateriales, double costoManoObra) {
		Item item= new Servicio(descripcion, costoMateriales, costoManoObra);
		pedido.agregar(item);
	}
	
	public FacturaExportacion facturarPedido(PedidoExportacion p) {
		FacturaExportacion factu= new FacturaExportacion(LocalDate.now(), p.getFechaExportacion(), p.getItems());
		this.facturas.add(factu);
		return factu;
	}
	
	public FacturaExportacion facturaMayorCostoEntre(LocalDate fechaInicio, LocalDate fechaFin) {
		return this.getFacturas().stream().
				filter(factura -> factura.getFechaFacturacion().isAfter(fechaInicio.minusDays(1))).
				filter(fac -> fac.getFechaFacturacion().isBefore(fechaFin.plusDays(1))).
				max(Comparator.comparing(FacturaExportacion::getCostoExportacion)).get();
	}
}
