package hilos.casino;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Banca {
 public enum Estado{Inicio,Aceptando_Apuestas,Ruleta_Girando,PagandoApuestas,En_Bancarrota};
 
 protected long saldo;
 protected int numeroGanador;
 protected boolean enBancarrota;
 protected boolean sePuedenHacerApuestas;
 protected Random generador;
 private Estado estadoRuleta;
 private ArrayList<jugador> jugadores;

 
 public Banca(long saldo) {
	super();
	this.saldo = saldo;
	this.enBancarrota=false;
	estadoRuleta=Estado.Inicio;
	generador=new Random();
	jugadores=new ArrayList<jugador>();
 }
 
 public synchronized boolean enBancarrota() {
	 return this.enBancarrota;
 }
 public synchronized void SumarSaldo(long cantidad) {
	 saldo+=cantidad;
 }
 public synchronized void restarSaldo(long cantidad) {
	 if(saldo-cantidad <=0) {
		 saldo -=cantidad;
	 }
 }
 public synchronized boolean aceptarApuestas() {
	 if(estadoRuleta==Estado.Aceptando_Apuestas) {
		 return true;
	 }
	 return false;
 }
 public synchronized void aceptarApuesta(jugador j) {
	 if(estadoRuleta==Estado.Aceptando_Apuestas) {
		jugadores.add(j);
	 }
 }
 public void cominicarNumeroGanador(int numero) {
	 for(jugador j:jugadores)j.comunicarNumero(numero);
	 jugadores.clear();
	 
 }
 public void girarRuleta() throws InterruptedException {
	 int segundosAzar;
	 System.out.println("¡¡Empieza el juego!!");
	 while (estadoRuleta !=Estado.En_Bancarrota) {
		estadoRuleta=Estado.Aceptando_Apuestas;
		/* Se eligen unos milisegundos al azar para que los jugadores apuesten*/
		segundosAzar=1+generador.nextInt(3);
		System.out.println("Hagan juego.Tienen ustedes "+segundosAzar+"segundos para hacer apuestas");
		Thread.sleep(1000*segundosAzar);
		System.out.println("ya no se admiten apuestas.");
		estadoRuleta=Estado.Ruleta_Girando;
		Thread.sleep(3000);
		numeroGanador=generador.nextInt(37);
		System.out.println("El numero ganador es "+numeroGanador);
		estadoRuleta=Estado.PagandoApuestas;
		this.cominicarNumeroGanador(segundosAzar);
		System.out.println("El saldo del banco es ahora "+saldo);
		
		
	}
 }
 public void simular(int nJugadoresClasicos,int nJugadoresParImpar,int nJugadoresMartinGala) throws InterruptedException {
	 Thread[] hJClasicos=new Thread[nJugadoresClasicos];
	 for (int i = 0; i < nJugadoresClasicos; i++) {
		hJClasicos[i]=new Thread( new JugadorClasico(1000,this));
		hJClasicos[i].setName("Jugador clasico "+(i+1));
		hJClasicos[i].start();
	}
	 Thread[] hJPar=new Thread[nJugadoresParImpar];
	 for (int i = 0; i < nJugadoresClasicos; i++) {
		hJClasicos[i]=new Thread( new JugadorParImpar(1000,this));
		hJClasicos[i].setName("Jugador Par/Impar "+(i+1));
		hJClasicos[i].start();
	}
	 
	 Thread[] hjMartinGala=new Thread[nJugadoresMartinGala];
	 for (int i = 0; i < nJugadoresMartinGala; i++) {
		 hJClasicos[i]=new Thread( new JugadorMartinGala(1000,this));
		 hJClasicos[i].setName("Jugador MartinGala "+(i+1));
		 hJClasicos[i].start();
	 }
	 
	 
	 this.girarRuleta();
 }
 public static void main(String[] arg) throws InterruptedException {
	 Banca b=new Banca(50000);
	 b.simular(5,5,5);
 }
}
