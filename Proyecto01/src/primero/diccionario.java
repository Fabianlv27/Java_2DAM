package primero;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class diccionario {
	
		public static Scanner sc=new Scanner(System.in);
	
	static HashMap<String,String> diccionario=new HashMap<>();
	
	public static String getTraduccion(String palabra) {
		
	if(!diccionario.containsKey(palabra)) {
		System.out.println("No se encontro la palabra, añadir traduccion: ");
		String tr=sc.next();
		diccionario.put(palabra, tr);
		return "Se añadio la palabra al diccionario :)";
	}
	return diccionario.get(palabra);
		
	}
public static void main(String[] args) {
	
	diccionario.put("perro", "dog");
	diccionario.put("casa", "House");
	diccionario.put("gato", "cat");
	
	int cont=0;
	
	do {
			System.out.println("Introduce una palabra:");
			String palabra=sc.next();
			System.out.println(getTraduccion(palabra));	
			try {
				System.out.println("Desea continuar? \n(0) si \n(1) no");
			cont=sc.nextInt();		
		}catch (Exception e) {
			System.out.println("Coloca 0/1 no otra cosa");
			// TODO: handle exception
		}
		
	} while (cont==0);
	
}
}
//hashmap cuya clave es un string y valor persona