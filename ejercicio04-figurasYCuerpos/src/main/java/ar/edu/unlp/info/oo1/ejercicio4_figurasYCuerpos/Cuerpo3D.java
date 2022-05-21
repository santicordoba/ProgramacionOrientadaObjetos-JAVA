package ar.edu.unlp.info.oo1.ejercicio4_figurasYCuerpos;

public class Cuerpo3D {
	private Figura caraBasal;
	private double altura;
	
	public void setAltura(double valor) {
		this.altura=valor;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal(Figura cara) {
		this.caraBasal=cara;
	}
	
	public Figura getCaraBasal() {
		return this.caraBasal;
	}

	
	public double getSuperficieExterior() {
		return (2*this.getCaraBasal().getArea())+(this.getCaraBasal().getPerimetro()*this.getAltura());
	}
	
	public double getVolumen(){
		return this.getCaraBasal().getArea()*this.getAltura();
	}

}
