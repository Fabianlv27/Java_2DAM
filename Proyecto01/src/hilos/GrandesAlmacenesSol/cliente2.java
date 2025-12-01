package hilos.GrandesAlmacenesSol;

import java.util.Random;

public class cliente2 extends Thread {
	Puerta puerta;
	Almacen2 almacen;
	String nombre;
	Random generador;
	
	final int  N_INTENTOS=10;

	public cliente2(Puerta puerta, Almacen2 almacen, String nombre) {
		super();
		this.puerta = puerta;
		this.almacen = almacen;
		this.nombre = nombre;
		generador=new Random();
	}
	
	public void esperar() {
		try {
			Thread.sleep(generador.nextInt(100));
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < N_INTENTOS; i++) {
			if (!puerta.isOcupada()) {
				if (puerta.intentarEntrar()) {
					esperar();
					puerta.liberarPuerta();
					if (almacen.cogerProductos()) {
						System.out.println(nombre + " :me cogi al producto");
						return;
					}else {
						System.out.println(nombre+": no cogi nada");
					}
					return;
				}
			}
		}
	}
	
}
