package hilos.casino;

import java.util.Random;

public abstract class jugador implements Runnable {
	protected long saldo;
	protected boolean enBancarota;
	protected long cantidadApostada;
	protected boolean apuestaRealizada;
	protected String nombreHilo;
	protected Banca banca;
	protected Random generador;
	
	public jugador(long saldo, Banca banca) {
		super();
		this.saldo = saldo;
		this.banca = banca;
		this.apuestaRealizada=false;
		generador=new Random();
	}

	
	public void sumarSaldo(long cantidad) {
		this.saldo +=cantidad;
	}
	
	public void restarSaldo(long cantidad) {
		if (this.saldo-cantidad <=0) {
			saldo=0;
			this.enBancarota=true;
			return;
		}
		this.saldo-=cantidad;
		
	}
	/* los usa para comunicarnos el numero ganador*/
	
	public abstract void comunicarNumero(int numero);
	
	public abstract void hacerApuesta();
	
	/* Todos los jugadores hacen lo mismo:
	 * mientras que no este en bancarrota y la bamnca tampoco lo este hacemos apuestas.
	 * La banca nos dira el numero que haya
	 * salido y en  ese momento (y si procede) incrementaremos el saldo.
 	 */
	
	public boolean enBancarrota() {return this.enBancarota;}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.nombreHilo=Thread.currentThread().getName();
		while(!this.enBancarota && !banca.enBancarrota()) {
			int msAzar;
			/* Mientras la ruleta no acepte apuestas,dormimos un periodo al azar*/
			
			while(!banca.aceptarApuestas()) {
				msAzar=generador.nextInt(500);
				try {
					Thread.sleep(msAzar);
				}catch(InterruptedException e) {
					return;
				}
			}
			hacerApuesta();
		}
		if (this.enBancarota) {
			System.out.println(this.nombreHilo+"Me arruine pipipi");
			return;
		}
		if (banca.enBancarrota()) {
			System.out.println(this.nombreHilo+"hizo saltar la banca");
		}
	}
}
