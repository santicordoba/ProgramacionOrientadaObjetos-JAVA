package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;

public class DateLapseSize implements DateLapse {
	private LocalDate from;
	private Integer sizeInDays;
	
	public DateLapseSize(LocalDate from, Integer size) {
		this.setFrom(from);
		this.setSizeInDays(size);
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	public Integer getSizeInDays() {
		return this.sizeInDays;
	}
	public void setSizeInDays(Integer sizeInDays) {
		this.sizeInDays = sizeInDays;
	}
	
	public int sizeInDays() {
	// “retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
		int cant=0;
		LocalDate to= this.getFrom().plusDays(this.sizeInDays);
		for (LocalDate date= this.from; date.isBefore(to); date= date.plusDays(1)) {
			cant++;
		}
		return cant;
	}
	
	public boolean includesDate(LocalDate otraFecha) {
		//“recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.
		LocalDate to= this.getFrom().plusDays(this.sizeInDays);
			if(this.getFrom().isBefore(otraFecha) && to.isAfter(otraFecha)) {
				return true;
			} else {
				if(this.getFrom().isEqual(otraFecha) || to.isEqual(otraFecha)) {
					return true;
				}
			}
			return false;
		}
	
	
}
