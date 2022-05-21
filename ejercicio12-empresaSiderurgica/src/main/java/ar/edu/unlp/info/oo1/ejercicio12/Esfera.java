package ar.edu.unlp.info.oo1.ejercicio12;

public class Esfera extends Pieza {
	private int radio;
	
	public Esfera(int radio, String material, String color) {
		this.setRadio(radio);
		this.setMaterial(material);
		this.setColor(color);
	}
	
	public int getRadio() {
		return this.radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	public double getVolumen() {
		// Volumen de una esfera: ⁴⁄₃ * π * radio 
		return (Math.PI*(Math.pow(this.getRadio(), 3))*4/3);
	}

	@Override
	public double getSuperficie() {
		// Superficie de una esfera: 4 * π * radio al cuadrado
		return (4 *(Math.PI*(Math.pow(this.getRadio(), 2))));
	}
	
}