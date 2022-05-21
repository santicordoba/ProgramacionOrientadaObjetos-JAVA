package ar.edu.unlp.info.oo1.ejercicio4_figurasYCuerpos;

public class Circulo implements Figura {
	private double radio;
	
	public void setRadio(double r) {
		this.radio=r;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public double getDiametro() {
		return this.getRadio()*2;
	}
	
	public double getPerimetro() {
		return Math.PI*this.getDiametro();
	}
	
	public double getArea() {
		return (Math.PI*(Math.pow(this.getRadio(), 2)));
	}
}
