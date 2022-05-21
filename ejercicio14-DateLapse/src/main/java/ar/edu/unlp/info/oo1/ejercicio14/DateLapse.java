package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;

public interface DateLapse {
	
	public int sizeInDays();
	
	public boolean includesDate(LocalDate otraFecha);
}
