package hilos;

public class Panaderia {
	private String pan;
	private boolean disponible;
	
	public synchronized void Hornear(String masa) {
		while(disponible) {
			try {
				wait();
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			
		}
		this.pan=masa;
		System.out.println("Panadero hornea "+this.pan);
		this.disponible=true;
		notify();
	}
	public synchronized String Consumir() {
		while (!disponible) {
		try {
			wait();
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		}
		System.out.println("El consumidor consume: "+this.pan);
		this.disponible=false;
		notify();
		return this.pan;
		
	}

}
