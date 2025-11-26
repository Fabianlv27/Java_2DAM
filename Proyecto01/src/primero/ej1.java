package primero;

import java.util.Iterator;
import java.util.Scanner;

public class ej1 {
	public static Scanner sc=new Scanner(System.in);
	
	public static void main(String[]args) {

		System.out.println("Dime un mes (1-12)");
		int num=Integer.valueOf(sc.nextLine()) ;
		String tri="";
		String Sem="";
		
		int trimestre=num/3;
		
		if (num%3==0) {
			System.out.println("su trimestre es: " + (trimestre));
			tri=String.valueOf(trimestre);
		}else {
			System.out.println("su trimestre es: " + (trimestre+1));
			tri=String.valueOf((trimestre+1));
		}
		
		int Semestre=num/6;
		if (num%3==0) {
			System.out.println("su Semestre es: " + (Semestre));
			Sem=String.valueOf(Semestre);
		}else {
			System.out.println("su Semestre es: " + (Semestre+1));
			Sem=String.valueOf((Semestre+1));
		}
		
		System.out.printf("El mes %2d pertenece al trimestre %s y al semestre %s ",num,tri,Sem);
	
		//decir en q decena esta un numero del 1 al 100
		
		System.out.println("dame otro numero: ");
		int num2=Integer.valueOf(sc.nextLine());
		int dec= (num2-1)/10;
		System.out.println("su decena es: " + (dec + 1 ));
		
		 // Sacar la parte entera uwu
		double t1=12.6;
		int t1int=(int)t1;
		
		
	}
}
