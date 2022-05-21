package ar.edu.unlp.info.oo1.ejercicio9;

public abstract class Cuenta {
	private double saldo;
	
	public Cuenta() {
		this.saldo=0;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double unMonto) {
		this.saldo=unMonto;
	}
	
	public void depositar(double unMonto) {
		this.saldo+=unMonto;
	}
	
	public boolean extraer(double unMonto) {
		if (this.puedeExtraer(unMonto)) {
			this.extraerSinControlar(unMonto);
			return true;
		}
		return false;
	}
	
	public boolean transfererirACuenta(double unMonto, Cuenta cuentaDestino) {
		if (this.puedeExtraer(unMonto)) {
			this.extraerSinControlar(unMonto);
			cuentaDestino.depositar(unMonto);
			return true;
		}
		return false;
	}
	
	protected void extraerSinControlar(double unMonto) {
		this.saldo-=unMonto;
	}
	
	protected abstract boolean puedeExtraer(double unMonto);
	
	
}
