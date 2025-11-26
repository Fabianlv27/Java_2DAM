package hilos;

import Ficheros.primos;

public class Inicio {
	
	public static void main(String[] args) {
	
		Thread hilo1=new Thread(new Tarea2("Tarea 1"));	
		Thread hilo2=new Thread(new Tarea2("Tarea 2"));	
		hilo1.start();
		try {
			hilo1.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		} 
		hilo2.start();
		try {
			hilo2.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}

class Tarea2 implements Runnable{
	private String nombre;
	private boolean activado;
	
	public Tarea2(String nombre) {
		super();
		this.nombre=nombre;
		this.activado=false;
		
	}
	public void desactivar() {
		this.activado=true;
	}
	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			System.out.println("Soy el hilo "+ i+nombre);
			try {
				Thread.sleep(500);
			}catch (InterruptedException e){
				System.out.println(e);
			}finally {
				System.out.println("Finalizado");
			}
		}
	}
}
