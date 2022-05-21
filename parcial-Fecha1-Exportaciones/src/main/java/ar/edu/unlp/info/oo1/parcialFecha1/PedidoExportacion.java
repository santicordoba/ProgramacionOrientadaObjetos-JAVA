package ar.edu.unlp.info.oo1.parcialFecha1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoExportacion {
	private String destino;
	private LocalDate fechaExportacion;
	private String nombreEmpresa;
	private List<Item> items;

	public PedidoExportacion(String destino, LocalDate fechaExportacion, String nombreEmpresa) {
		this.setDestino(destino);
		this.setFechaExportacion(fechaExportacion);
		this.setNombreEmpresa(nombreEmpresa);
		this.items= new ArrayList<Item>();
	}

	public void setFechaExportacion(LocalDate fechaExportacion) {
		this.fechaExportacion = fechaExportacion;
	}

	public void agregar(Item i) {
		this.items.add(i);
		
	}

	public LocalDate getFechaExportacion() {
		return this.fechaExportacion;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


}
