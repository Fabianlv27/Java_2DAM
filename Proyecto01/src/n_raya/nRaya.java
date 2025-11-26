package n_raya;
import java.util.Scanner;

public class nRaya {
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("ingrese el numero");
		int n=sc.nextInt();
		System.out.println("soluciones posibles");
		System.out.println("filas: ");
		for (int i = 1; i <=(n*n); i++) {
			
			System.out.print(i+"\t");
			if(i%n==0)System.out.println("");
		}
		System.out.println("columnas: ");
		for (int i = 1; i <=n; i++) {
			
			for (int j = i; j <=(n*(n-1)+i); j+=n) {
			System.out.print(j+"\t");

			}
			System.out.println("");
			
					}
}
}