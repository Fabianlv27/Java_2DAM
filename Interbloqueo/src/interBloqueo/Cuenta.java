package interBloqueo;

public class Cuenta {
private int saldo;
private String numCuenta;

	public Cuenta(int saldo, String numCuenta) {
	super();
	this.saldo = saldo;
	this.numCuenta = numCuenta;
}

	public Cuenta() {
		
	}
	
	public String getNumeCuenta() {
		return this.numCuenta;
	}
	public synchronized int getSaldo() {
		return this.saldo;
	}
	public synchronized void ingresar(int cantidad) {
		this.saldo +=cantidad;
	}
	public synchronized void sacar(int cantidad) {
		this.saldo -=cantidad;
	}

}
