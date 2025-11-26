package Ficheros;

public class piramide {
	public static void main(String[] args) {
		int nivel=4;

		
		for (int i = 1; i <=nivel; i++) {
			System.out.println(" ".repeat(nivel-i)+"❤️".repeat((2*i)-1));
		}
		
		

		for (int i = nivel; i>0; i--) {
			System.out.println(" ".repeat(nivel-i)+"".repeat((2*(i-1))+1));
		}
		//izquierda
		System.out.println("\n");
		for (int i = 1; i <=nivel; i++) {
			System.out.println("  ".repeat(nivel-i)+"💀".repeat(i));
		}
		
		for (int i = 1; i<=nivel; i++) {
			System.out.println("  ".repeat(i)+"💀".repeat(nivel-i));
		}
		
		//derecha
		

		for (int i = 1; i <=nivel; i++) {
			System.out.println("💀".repeat(i)+"  ".repeat(nivel-i));
		}
		
		for (int i = 1; i<=nivel; i++) {
			System.out.println("💀".repeat(nivel-i)+"  ".repeat(i));
		}
		
		//pasarle un argumento a un fichero y la palabra que queremos
		//saber cuantas veces se repite

		
	}
	
	
}
