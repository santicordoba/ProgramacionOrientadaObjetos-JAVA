package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.setFrom(from);
		this.setTo(to);
	}
	
	public LocalDate getFrom() {
	// “Retorna la fecha de inicio del rango”
		return this.from;
	}
	
	public LocalDate getTo() {
	// “Retorna la fecha de fin del rango”
		return this.to;
	}
	
	public void setFrom(LocalDate from) {
		this.from= from;
	}
	
	public void setTo(LocalDate to) {
		this.to= to;
	}
	
	public int sizeInDays() {
	// “retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
		int cant=0;
		for (LocalDate date= this.from; date.isBefore(this.to); date= date.plusDays(1)) {
			cant++;
		}
		return cant;
	}
	
	public boolean includesDate(LocalDate otraFecha) {
	//“recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.
		if(this.getFrom().isBefore(otraFecha) && this.getTo().isAfter(otraFecha)) {
			return true;
		} else {
			if(this.getFrom().isEqual(otraFecha) || this.getTo().isEqual(otraFecha)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean overlaps (DateLapse anotherDateLapse) {
		if(anotherDateLapse.includesDate(this.getFrom()) || anotherDateLapse.includesDate(this.getTo())) {
			return true;
		}
		return false;
	}
}
