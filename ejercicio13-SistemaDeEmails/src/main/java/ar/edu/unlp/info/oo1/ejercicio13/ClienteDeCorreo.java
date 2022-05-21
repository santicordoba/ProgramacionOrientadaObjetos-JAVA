package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDeCorreo {
	List<Carpeta> carpetas;
	Carpeta inbox;
	
	public ClienteDeCorreo() {
		this.carpetas= new ArrayList<Carpeta>();
		this.inbox= new Carpeta("Inbox");
	}
	
	public void recibir(Email email) {
		this.getInbox().agregarEmail(email);

	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		//#mover, mueve el email que viene como parámetro de la carpeta origen a la carpeta destino
		//(asuma que el email está en la carpeta origen cuando se recibe este mensaje).
		origen.eliminarEmail(email);
		destino.agregarEmail(email);
	}
	
	public Email buscar(String texto) {
		//#buscar retorna el primer email que encuentra cuyo título o cuerpo contienen el texto 
		//indicado como parámetro. Busca en todas las carpetas. 
		List<Carpeta> temp= this.getCarpetas();
		temp.add(this.getInbox());
		List<Email> lista= temp.stream().map(c -> c.obtenerEmailConTexto(texto)).collect(Collectors.toList()).get(0);
		return lista.get(0);
	}
	
	public Integer espacioOcupado() {
		//espacioOcupado, retorna la suma del espacio ocupado por todos los emails de todas las carpetas.
		List<Carpeta> temp= this.getCarpetas();
		temp.add(this.getInbox());
		return temp.stream().mapToInt(c -> c.tamanio()).sum();
	}
	
	public Carpeta getInbox(){
		return this.inbox;
	}
	
	public List<Carpeta> getCarpetas(){
		return this.carpetas;
	}
	
	public void agregarCarpeta(Carpeta c) {
		this.getCarpetas().add(c);
	}
	
}
