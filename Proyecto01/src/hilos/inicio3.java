package hilos;


public class inicio3 {
			public static final int NUM_HILOS=10;
		public static final int CUENTA_TOTAL=1_000_000_000;
		
	public static void main(String[] args) throws InterruptedException{
		Contador c=new Contador();
		Tarea4[] hilos=new Tarea4[NUM_HILOS];
		
		for (int i = 0; i < NUM_HILOS; i++) {
			hilos[i]=new Tarea4(i,CUENTA_TOTAL/NUM_HILOS,c);
			hilos[i].start();
		}
		
		try {
			for (Thread h : hilos) {
				h.join();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.printf("Cuenta global:%d\s ",c.getCuenta());
		
		
	}
}

class Contador2{
	private int cuenta=0;
	synchronized public int getCuenta() {return cuenta;}
	synchronized public int incrementa() {return cuenta++;}
}



class Tarea4 extends Thread{
	int numHilo,miParte,miCuenta=0;
	private final Contador cont;
	
	public Tarea4(int numHilo,int miParte,Contador cont) {
		super();
		this.numHilo=numHilo;
		this.miParte=miParte;
		this.cont=cont;
}
	public int getMicuenta() {return miCuenta;}
	

	public void run() {
		
		for (int i = 0; i < miParte; i++) {
			this.cont.incrementa();
			miCuenta++;
		}
		System.out.printf("Hilo %d terminado,cuenta: %d\n",numHilo,getMicuenta());
	}
}