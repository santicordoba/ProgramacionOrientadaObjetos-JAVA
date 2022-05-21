package ar.edu.unlp.info.oo1.ejercicio15;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ServicioDeRegistros {
	private List<Usuario> usuarios;
	private List<Propiedad> propiedades;
	
	public ServicioDeRegistros() {
		this.usuarios= new ArrayList<Usuario>();
		this.propiedades= new ArrayList<Propiedad>();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario registrarUsuario(String nombre, String direccion, Integer dni) {
		Usuario user= new Usuario(nombre, direccion, dni);
		this.getUsuarios().add(user);
		return user;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioPorNoche, String direccion, Usuario propietario) {
		Propiedad prop= new Propiedad(nombre, descripcion, precioPorNoche, direccion, propietario);
		this.getPropiedades().add(prop);
		return prop;
	}
	
	public List<Propiedad> buscarPropiedad(DateLapse periodo){
		List<Propiedad> lista;
		lista=this.getPropiedades().stream().filter(prop -> prop.libre(periodo)).toList();
		return lista;
	}
	
	public Reserva hacerUnaReserva(Propiedad prop, DateLapse periodo, Usuario user) {
		Reserva res=null;
		if(prop.libre(periodo)) {
			res= new Reserva(periodo, user, prop);
			prop.getReservas().add(res);
		}
		return res;
	}
	
	public List<Propiedad> propiedadesPorPropietario(Usuario propietario){
		List<Propiedad> lista;
		lista= this.getPropiedades().stream().filter(prop -> prop.getPropietario().getDni() == propietario.getDni()).toList();
		return lista;
	}
	
	public void eliminarReserva(Reserva res) {
		if (res.getPeriodo().getFrom().isAfter(LocalDate.now())) {
			res.getPropiedad().getReservas().remove(res);
		}
	}
	
	
	public double calcularIngresosPropietario(DateLapse periodo, Usuario propietario) {
		List<Propiedad> propiedades= this.propiedadesPorPropietario(propietario);
		double ingresos= propiedades.stream().mapToDouble(prop -> prop.calcularIngresosPropiedadEn(periodo)).sum();
		return ingresos;
	}
	
}
