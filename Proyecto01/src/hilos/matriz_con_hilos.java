package hilos;

import java.util.Date;

public class matriz_con_hilos {
	
	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Cantidad de nucleos del procesador: "+
		Runtime.getRuntime().availableProcessors());
		
		int[] vector=new int[500_000_000];
		for (int i = 0; i < vector.length; i++)vector[i]=alea(1,200_000_000);
		
		System.out.println("Fin de la carga del vector.");
		Date d1=new Date();
		
		HiloMayor hilo1=new HiloMayor();
		HiloMayor hilo2=new HiloMayor();
		
		hilo1.fijarRango(0, vector.length/2, vector);
		hilo2.fijarRango(vector.length/2 + 1,vector.length -1, vector);
		
		hilo1.start();
		hilo2.start();
		
		while(hilo1.isAlive()||hilo2.isAlive());
		
		System.out.println("Mayor elemento del vector");
		
		if(hilo1.may > hilo2.may) System.out.println(hilo1.may);
		else System.out.println(hilo2.may);
		
		Date d2=new Date();
		long milisegundos=(d2.getTime()-d1.getTime());
		
		System.out.println("Milisegundos requeridos con 2 hilos:"+milisegundos);
		//Recorrer sin hilos
		d1=new Date();
		
		int may=vector[0];
		for (int f = 1; f < vector.length; f++) {
			if (vector[f]>may) may=vector[f] ;
		}
		
		d2=new Date();
		
		milisegundos=(d2.getTime()-d1.getTime());
		System.out.println("Milisegundos requeridos sin hilos:"+milisegundos);
		//poner una variable numero de hilos, hacer tantos hilos como indique la
		//variable
		
	}

}

class HiloMayor extends Thread{
	
	int[] v;
	int ini,fin;
	int may;
	
	void fijarRango(int i,int f,int[] v){
		System.out.println(i+"  "+f);
		this.ini=i;
		this.fin=f;
		this.v=v;
		
	}
	
	public void run() {
		
		may=v[ini];
		for (int f = ini; f < fin; f++) {
			if (v[f]>may) may=v[f] ;
		}
	}
}
