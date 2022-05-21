package ar.edu.unlp.info.oo1.parcialFecha1;

public class Servicio extends Item {
	private double costoMateriales;
	private double costoManoObra;

	public Servicio(String descripcion, double costoMateriales, double costoManoObra) {
		super(descripcion);
		this.setCostoMateriales(costoMateriales);
		this.setCostoManoObra(costoManoObra);
	}

	@Override
	public double costo() {
		return this.getCostoMateriales()+this.getCostoManoObra();
	}

	public double getCostoManoObra() {
		return costoManoObra;
	}

	public void setCostoManoObra(double costoManoObra) {
		this.costoManoObra = costoManoObra;
	}

	public double getCostoMateriales() {
		return costoMateriales;
	}

	public void setCostoMateriales(double costoMateriales) {
		this.costoMateriales = costoMateriales;
	}

}
