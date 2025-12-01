package hilos.GrandesAlmacenesSol;


public class Puerta {
	boolean ocupada;
	
	public Puerta(boolean ocupada) {
		super();
		this.ocupada = ocupada;
	}
	
	

	public boolean isOcupada() {
		return ocupada;
	}



	public synchronized void liberarPuerta() {
		this.ocupada = false;
	}

	public synchronized boolean intentarEntrar() {
		if (ocupada) {
			return false;
		}
		ocupada=!ocupada;
		return ocupada;
	}

	public Puerta() {
		
	}

}
