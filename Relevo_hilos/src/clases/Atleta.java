package clases;

public class Atleta extends Thread{
	private String nombre;
	private double duracion;
	private Object testigo;
	
	public Atleta(String nombre, Object testigo) {
		super();
		this.nombre = nombre;
		this.testigo = testigo;
		this.duracion=0;
	}

	public double getDuracion() {
		return duracion;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Ha empezado la carrera. ");
		
		long ini=System.currentTimeMillis();
		
		try {
			//simulamos el tiempo de la carrera
			long n=(long)(Math.random()*(11-9+1))+9;
			Thread.sleep(n*1000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(nombre + "ha terminado");
		
		synchronized(testigo) {
			
			System.out.println(nombre +"ha pasado el testigo.");
			testigo.notify();
			long fin =System.currentTimeMillis();
			duracion=(double)(fin-ini)/1000;
			System.out.println("Tiempo total "+duracion+"segundos");
		}
		super.run();
	}
	
	
	
	
}
