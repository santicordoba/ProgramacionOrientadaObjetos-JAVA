package ar.edu.unlp.info.oo1.ejercicio12;

public class PrismaRectangular extends Pieza {
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(int ladoMayor, int ladoMenor, int altura, String material, String color) {
		this.setLadoMayor(ladoMayor);
		this.setLadoMenor(ladoMenor);
		this.setAltura(altura);
		this.setMaterial(material);
		this.setColor(color);
	}
	
	public int getLadoMayor() {
		return this.ladoMayor;
	}
	public void setLadoMayor(int ladoMayor) {
		this.ladoMayor = ladoMayor;
	}
	public int getLadoMenor() {
		return this.ladoMenor;
	}
	public void setLadoMenor(int ladoMenor) {
		this.ladoMenor = ladoMenor;
	}
	public int getAltura() {
		return this.altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	@Override
	public double getVolumen() {
		// Volumen del prisma: ladoMayor * ladoMenor * altura
		return (this.getLadoMayor()*this.getLadoMenor()*this.getAltura());
	}
	@Override
	public double getSuperficie() {
		// Superficie del prisma: 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura)
		return 2*(this.getLadoMayor()*this.getLadoMenor()+this.getLadoMayor()*this.getAltura()+this.getLadoMenor()*this.getAltura());
	}
	

	
}
