package ar.edu.unlp.info.oo1.parcialFecha1;

import java.time.LocalDate;
import java.util.List;

public class FacturaExportacion {
	private LocalDate fechaFacturacion;
	private LocalDate fechaExportacion;
	private List<Item> items;

	public FacturaExportacion(LocalDate fechaFac, LocalDate fechaExp, List<Item> items) {
		this.setFechaExportacion(fechaExp);
		this.setFechaFacturacion(fechaFac);
		this.setItems(items);
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public LocalDate getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(LocalDate fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	public List<Item> getItems() {
		return items;
	}

	public LocalDate getFechaExportacion() {
		return fechaExportacion;
	}

	public void setFechaExportacion(LocalDate fechaExportacion) {
		this.fechaExportacion = fechaExportacion;
	}
	
	public double costoBasico() {
		if(this.getItems().size()>0) {
			double monto= this.getItems().stream().mapToDouble(items -> items.costo()).sum();
			return monto;
		} else {
			return 0.0;
		}
	}
	
	public double getCostoExportacion() {
		return this.costoBasico()*0.05;
	}
	
	public double getCostoFinal() {
		return this.costoBasico()+this.getCostoExportacion();
	}


}
