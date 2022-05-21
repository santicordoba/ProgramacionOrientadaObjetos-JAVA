package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta {


	public CajaDeAhorro() {
		super.setSaldo(0);
	}



	@Override
	public void depositar(double unMonto) {
		//Deposita un 2% menos por el fee
		super.depositar(unMonto*0.98);

	}

	@Override
	protected void extraerSinControlar(double unMonto) {
		//Se descuenta el saldo + el 2% de fee
		super.extraerSinControlar(unMonto);
		super.setSaldo(super.getSaldo() - unMonto*0.02);

	}

	@Override
	protected boolean puedeExtraer(double unMonto) {
		//Para extraer necesita tener en cuenta un 2% más del monto
		if (super.getSaldo() >= unMonto*1.02) {
			return true;
		}
		return false;
	}

}
