package primero;
import java.util.Scanner;

import clase.menu;

public class ej10 {
		public static Scanner sc=new Scanner(System.in);
		
public static void main(String[] args) {
	int opcion;
	String basura;
	boolean seguir=true;
	String[] opciones= {"1.-suma","2.-resta","3.-salir"};
	
	
	while(seguir) {
		opcion=menu.menu(sc,opciones);
		switch (opcion) {
	case 1: {
		System.out.println("sumando....");
		break;
	}
	case 2: {
		System.out.println("restando....");
	}
	case 3: {
		seguir=false;
		break;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + opcion);
	}
		if (opcion!=3) {
			sc.nextLine();
			System.out.println("Pulse cualquier tecla para continuar:");
			basura=sc.nextLine();
		}
	}
	
	
}
}
