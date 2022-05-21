package ar.edu.unlp.info.oo1.parcialFarolas;

public class LightSensor {
	private Boolean dark;
	
	public LightSensor(Boolean estado) {
		this.dark=estado;
	}

	public Boolean getDark() {
		return dark;
	}

	public void setDark(Boolean dark) {
		this.dark = dark;
	}
	
	public Boolean isDark() {
		return this.getDark();
	}
	
	

}
