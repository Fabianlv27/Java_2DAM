package primero;
 import java.util.Scanner;
public class notas {
	
		public static Scanner sc=new Scanner(System.in);
		
 public static void main(String[] args) {
	 System.out.println("Dime cual es tu nota?");
	 double tri1=sc.nextInt();
	 
	 if (tri1<=5) {
		System.out.println("JAJAJJAJAJAJ suicidate mejor");
	}else {
		System.out.println("ala roy");
	}
	 System.out.println("Dime cual es tu meta?");
	 double meta=sc.nextInt();
	 if (meta >=8) {
		System.out.println("mejor vete a bucodental");
	}else {
		System.out.println("puta q rico e");
	}
	 //final=0.4t1 +0.6t2
	 double tri2= (meta-(tri1*0.4))/0.6;
	 System.out.println("Tienes que sacar: " + tri2+ " en el segundo trimestre");
}
}
//pedir pon pantalla el numero de filas y columnas
//crear una matriz bidimensional y rellenar con numeros 
//random de 0-10. imprimir la matriz en las que esten inculidas
//la suma de los valores por fila y por columnas.
