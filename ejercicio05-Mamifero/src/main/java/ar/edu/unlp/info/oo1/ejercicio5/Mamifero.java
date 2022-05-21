package ar.edu.unlp.info.oo1.ejercicio5;

public class Mamifero {
	Mamifero padre;
	Mamifero madre;
	String especie;
	String identificador;

	public Mamifero(String nombre) {
		this.setIdentificador(nombre);
		padre=null;
		madre=null;
	}

	public Mamifero() {
		padre=null;
		madre=null;
	}

	public void setPadre(Mamifero padre) {
		this.padre=padre;
		
	}

	public void setMadre(Mamifero madre) {
		this.madre=madre;
		
	}

	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null) {
			return this.getMadre().getMadre();
		} else {
			return null;
		}
		
	}

	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null) {
			return this.getPadre().getMadre();
		} else {
			return null;
		}
	}

	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null) {
			return this.getMadre().getPadre();
		} else {
			return null;
		}
	}

	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null) {
			return this.getPadre().getPadre();	
		} else {
			return null;
		}
	}

	public void setEspecie(String especie) {
		this.especie=especie;		
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setIdentificador(String identificador) {
		this.identificador=identificador;
		
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public Mamifero getMadre() {
		return this.madre;
	}

	public Mamifero getPadre() {
		return this.padre;
	}

	public Boolean tieneComoAncestroA(Mamifero otroMamifero) {
		Boolean ok=false;
		if(this.getMadre() == null && this.getPadre() == null) {
			return false;
		}
		if (this.getPadre()== otroMamifero || this.getMadre() == otroMamifero) {
			return true;
		} if (this.getMadre() != null && ok==false) {
			ok= this.getMadre().tieneComoAncestroA(otroMamifero);
		} if (this.getPadre() != null && ok==false) {
			ok= this.getPadre().tieneComoAncestroA(otroMamifero);
		}
		return ok;
	}

}
