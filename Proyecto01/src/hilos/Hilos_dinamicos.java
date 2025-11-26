package hilos;

import java.util.Date;

public class Hilos_dinamicos {
	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	static int Nhilos=3;
	
	static HiloMayor[] hilos=new HiloMayor[Nhilos];
	static int[] vector=new int[500_000_000];
	static int divi=vector.length/Nhilos;
	
	public static void main(String[] args) {
	System.out.println(divi);
		for (int i = 0; i < vector.length; i++)vector[i]=alea(1,200_000_000);
		
		
		int z=0;
		for (int i = 0; i <Nhilos; i++) {
			if(i!=0)z=1;
			//System.out.printf("%d %d\n",(i*divi)+z,(i+1)*divi);
			hilos[i]=new HiloMayor();
			hilos[i].fijarRango((i*divi)+z, (i+1)*divi, vector);
		}
		
		
		/*for (int i = 0; i <Nhilos; i++) {
			hilos[i]=new HiloMayor();
			System.out.println((int)(((vector.length-(Nhilos*(i+1)))/Nhilos))+(i*Nhilos));
			int inicial=((int)(((vector.length-(Nhilos*(i+1)))/Nhilos))+(i*Nhilos)) -1;
			int fin=inicial+(i*Nhilos);
			if(i==Nhilos-1)fin=vector.length-1;
			hilos[i].fijarRango(inicial,fin, vector);
		}
		*/
		Date d1=new Date();
		for (int i = 0; i <Nhilos; i++)hilos[i].start();

		boolean sigo=true;
		
		while (sigo) {
			sigo=false;
			for (int i = 0; i <Nhilos; i++) {
				if (hilos[i].isAlive()) {
					sigo=true;
					break;
				}
			}
			
		}
		
		for(int i = 0; i <Nhilos; i++) {
			while(hilos[i].isAlive());
		}
		
		int mayor=hilos[0].may;
		//System.out.println(mayor);
		for (int i = 1; i < hilos.length; i++) {
			//System.out.println(hilos[i].may);
			if (hilos[i].may>mayor) {
				mayor=hilos[i].may;
			}
		}
		
System.out.println("Mayor elemento del vector");
System.out.println(mayor);
		Date d2=new Date();
		long milisegundos=(d2.getTime()-d1.getTime());
		
		System.out.println("Milisegundos requeridos con"+Nhilos+" hilos:"+milisegundos);
	
		
	}
}
