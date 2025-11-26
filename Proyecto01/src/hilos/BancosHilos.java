package hilos;

import java.util.Iterator;

public class BancosHilos {
	
	public static void main(String[] args) throws InterruptedException {
		Cuenta cuenta = new Cuenta(100);
		final int C100=40;
		final int C50=20;
		final int C20=60;
		
		Thread[] hI100=new Thread[C100];
		Thread[] hR100=new Thread[C100];
		
		Thread[] hI50=new Thread[C50];
		Thread[] hR50=new Thread[C50];
		
		Thread[] hI20=new Thread[C20];
		Thread[] hR20=new Thread[C20];
		
		for (int i = 0; i < C100; i++) {
			hI100[i]=new Thread(new Hilo_Cliente(cuenta,100));
			hR100[i]=new Thread(new Hilo_Cliente(cuenta,-100));
			hI100[i].start();
			hR100[i].start();
		}
		
		for (int i = 0; i < C50; i++) {
			hI50[i]=new Thread(new Hilo_Cliente(cuenta,100));
			hR50[i]=new Thread(new Hilo_Cliente(cuenta,-100));
			hI50[i].start();
			hR50[i].start();
		}
		
		for (int i = 0; i < C20; i++) {
			hI20[i]=new Thread(new Hilo_Cliente(cuenta,100));
			hR20[i]=new Thread(new Hilo_Cliente(cuenta,-100));
			hI20[i].start();
			hR20[i].start();
		}
		
		
		for (int i = 0; i < C100; i++) {
			hI100[i].join();
			hR100[i].join();
		}
		for (int i = 0; i < C50; i++) {
			hI50[i].join();
			hR50[i].join();
		}
		for (int i = 0; i < C20; i++) {
			hI20[i].join();
			hR20[i].join();
		}
		
		if (cuenta.esSimulacionCorrecta()) {
		 System.out.println("Simulacion Correcta");
		}else {
			System.out.println("Simulacion Incorrecta");
			System.out.println("la cuenta tiene un saldo de"+cuenta.getSaldo());
			
		}
	}
	
	
}

class Cuenta{
	int Saldo;
	int Saldo_Inicial;
	
	public Cuenta(int Saldo) {
		this.Saldo=Saldo;
		this.Saldo_Inicial=Saldo;
	}
	public int getSaldo() {
		return Saldo;
	}
	public synchronized void hacerMovimiento(int cantidad) {
		this.Saldo +=cantidad;
	}
	public synchronized boolean esSimulacionCorrecta() {
		if (this.Saldo==this.Saldo_Inicial)return true;
		return false;
	}
	public void setSaldo(int saldo) {
		Saldo = saldo;
	}
	
}

 class Hilo_Cliente extends Thread{
	 int cantidad;
	 Cuenta c;
	 
	public Hilo_Cliente(Cuenta cuenta,int cantidad) {
		this.c=cuenta;
		this.cantidad=cantidad;
	}
	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			c.hacerMovimiento(cantidad);
		}
	}
}
