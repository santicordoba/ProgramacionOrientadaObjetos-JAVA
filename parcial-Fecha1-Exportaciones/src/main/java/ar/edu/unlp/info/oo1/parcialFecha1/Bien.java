package ar.edu.unlp.info.oo1.parcialFecha1;

public class Bien extends Item{
	private int cantUnidades;
	private double pesoUnidad;
	private double valorUnidad;

	public Bien(String descripcion, int unidades, double peso, double valorUnidad) {
		super(descripcion);
		this.setCantUnidades(unidades);
		this.setPesoUnidad(peso);
		this.setValorUnidad(valorUnidad);
	}

	@Override
	public double costo() {
		double pesoTotal= this.getPesoUnidad()*this.getCantUnidades();
		double costo= this.getCantUnidades()*this.getValorUnidad();
		if(pesoTotal>1000) {
			return costo*1.10;
		} else {
			return costo;
		}
	}

	public int getCantUnidades() {
		return cantUnidades;
	}

	public void setCantUnidades(int cantUnidades) {
		this.cantUnidades = cantUnidades;
	}

	public double getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(double valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	public double getPesoUnidad() {
		return pesoUnidad;
	}

	public void setPesoUnidad(double pesoUnidad) {
		this.pesoUnidad = pesoUnidad;
	}

}
