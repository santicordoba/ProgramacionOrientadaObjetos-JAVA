package ar.edu.unlp.info.oo1.ejercicio15;


public class Reserva {
	private DateLapse periodo;
	private Usuario inquilino;
	private Propiedad propiedad;
	
	public Reserva(DateLapse periodo, Usuario inquilino, Propiedad prop){
		this.setPeriodo(periodo);
		this.setInquilino(inquilino);
		this.setPropiedad(prop);
	}
	
	public DateLapse getPeriodo() {
		return this.periodo;
	}
	public void setPeriodo(DateLapse periodo) {
		this.periodo = periodo;
	}

	public Usuario getInquilino() {
		return this.inquilino;
	}

	public void setInquilino(Usuario inquilino) {
		this.inquilino = inquilino;
	}

	public Propiedad getPropiedad() {
		return this.propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	public double valor() {
		return this.getPeriodo().sizeInDays()*this.getPropiedad().getPrecioPorNoche();
	}
	
	

}
