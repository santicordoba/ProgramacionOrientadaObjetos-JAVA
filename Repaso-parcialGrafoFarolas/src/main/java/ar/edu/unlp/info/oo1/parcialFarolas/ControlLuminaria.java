package ar.edu.unlp.info.oo1.parcialFarolas;

import java.util.ArrayList;
import java.util.List;

public class ControlLuminaria {
	private List<Farola> redesDeFarolas;
	
	public ControlLuminaria() {
		this.redesDeFarolas= new ArrayList<Farola>();
	}

	public List<Farola> getRedesDeFarolas() {
		return redesDeFarolas;
	}
	
	public void agregarRed(Farola unaRed) {
		this.redesDeFarolas.add(unaRed);
	}
	
	public Boolean estadoNocturno() {
		List<Boolean> listaEstado= this.getRedesDeFarolas().stream().map(farola -> farola.estadoNocturno()).toList();
		if (listaEstado.contains(true)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void controlarLuminarias() {
		if(this.estadoNocturno()) {
			for(Farola red: this.redesDeFarolas) {
				red.encender();
			}
		} else {
			this.redesDeFarolas.stream().forEach(red -> red.apagar());
		}
		
	}
	

}
