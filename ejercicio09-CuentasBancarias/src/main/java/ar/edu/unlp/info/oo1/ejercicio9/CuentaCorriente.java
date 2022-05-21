package ar.edu.unlp.info.oo1.ejercicio9;

public class CuentaCorriente extends Cuenta {
	private double limite;

	public CuentaCorriente() {
		super.setSaldo(0);
		this.setLimite(0);
	}

	@Override
	protected boolean puedeExtraer(double unMonto) {
		if (super.getSaldo() + this.getLimite() >= unMonto) {
			return true;
		}
		return false;
	}

	public double getLimite() {
		return this.limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}
