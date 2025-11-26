package primero;
import java.util.Scanner;
public class EJ3 {
	
	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("inserta un año");
		int año=sc.nextInt();
		if ((año%4==0 ||año%100!=0 )&& año%400==0) {
			System.out.println("Es año bisiesto uwu");
		}else {
			System.out.println("No es año bisiesto ");
		}
	}

}
