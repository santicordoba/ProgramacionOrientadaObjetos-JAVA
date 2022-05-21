package ar.edu.unlp.info.oo1.parcialFecha1;

public abstract class Item {
	private String descripcion;
	
	public Item(String descripcion) {
		this.setDescripcion(descripcion);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public abstract double costo();

}
