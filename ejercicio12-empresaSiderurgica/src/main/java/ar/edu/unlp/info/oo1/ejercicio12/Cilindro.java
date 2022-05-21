package ar.edu.unlp.info.oo1.ejercicio12;

public class Cilindro extends Pieza{
	private int radio;
	private int altura;
	
	public Cilindro(int radio, int altura, String material, String color) {
		this.setRadio(radio);
		this.setAltura(altura);
		this.setMaterial(material);
		this.setColor(color);
	}
	
	public int getRadio() {
		return radio;
	}
	public void setRadio(int radio) {
		this.radio = radio;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	@Override
	public double getVolumen() {
		//Volumen de un cilindro: π * radio al cuadrado * altura.
		return (Math.PI*(Math.pow(this.getRadio(), 2))*this.getAltura());
	}
	@Override
	public double getSuperficie() {
		// Superficie de un cilindro: 2 * π * radio  * h + 2 * π * radio AL CUADRADO
		return (2 * Math.PI * this.getRadio() * this.getAltura()) + (2 * (Math.PI*(Math.pow(this.getRadio(), 2))));
	}
	
}
