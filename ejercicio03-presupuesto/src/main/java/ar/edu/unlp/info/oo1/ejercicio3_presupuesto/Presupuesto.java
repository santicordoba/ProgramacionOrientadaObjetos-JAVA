package ar.edu.unlp.info.oo1.ejercicio3_presupuesto;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Presupuesto {

	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto() {
		this.items=  new ArrayList<Item>();
	}
	
	public Presupuesto fecha (LocalDate f) {
		this.fecha=f;
		return this;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public Presupuesto cliente (String c) {
		this.cliente=c;
		return this;
	}
	
	public String getCliente () {
		return this.cliente;
	}
	
	public List<Item> agregarItem (Item i) {
		items.add(i);
		return items;
	}
	
	public double calcularTotal0() {
		double costo=0;
		for(int i=0; i< this.items.size(); i++) {
			costo= costo + this.items.get(i).costo();
		}
		return costo;
	}
	
	public double calcularTotal() {
		double total = this.items.stream().mapToDouble(Item::costo).sum();
		return total;
	}
	
	public static void main(String[] parametros){
		System.out.println("hola mundo");
		Presupuesto presupuesto = new Presupuesto().cliente("Pedro");
		Item item = new Item().detalle("Leche").costoUnitario(100).cantidad(2);
		presupuesto.agregarItem(item);
		Item item1 = new Item().detalle("Salchichas").costoUnitario(90).cantidad(1);
		presupuesto.agregarItem(item1);
		Item item11 = new Item().detalle("Pan").costoUnitario(80).cantidad(1);
		presupuesto.agregarItem(item11);		
		System.out.println(presupuesto.calcularTotal());
	}

}
