package E1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import clases.Electrodomestico;
import clases.Lavadora;
import clases.Televisor;

public class E1 {
	static Electrodomestico[] elementos=new Electrodomestico[10];
	
	public static void llenar_array() {
		 elementos[0] = new Lavadora(10, 20, "verde", 'A', 10);
		 elementos[1] = new Lavadora(20, 5, "rojo", 'C', 30);
		 elementos[2] = new Televisor(5, 20, "negro", 'F');
		 elementos[3] = new Televisor(15, 10, "blanco", 'B');
		 elementos[4] = new Lavadora(25, 15, "azul", 'D', 40);
		 elementos[5] = new Televisor(30, 25, "gris", 'E');
		 elementos[6] = new Lavadora(35, 12, "negro", 'A', 25);
		 elementos[7] = new Televisor(40, 18, "rojo", 'C');
		 elementos[8] = new Lavadora(45, 22, "blanco", 'B', 50);
		 elementos[9] = new Televisor(50, 30, "azul", 'D');
	}
	
	 public static void Recorrer() {
		 int suma_lavadora=0;
		 int suma_tele=0;
		 
		  for(Electrodomestico e:elementos) {
			  e.calcular_precio();
			
		  }
		 
		 for(int i=0;i<elementos.length;i++) {
		
		       if (elementos[i] instanceof Lavadora) {
		 
		            suma_lavadora += elementos[i].getPrecio_base();
		        } else {
	
		            suma_tele += elementos[i].getPrecio_base();
		        }
		 }
		
		 System.out.println("precio total de lavadoras: "+ suma_lavadora);
		 System.out.println("precio total de televisiones: "+ suma_tele);
		 System.out.println("precio total de todos: "+ (suma_lavadora + suma_tele));
	 }
	 public static void main(String[] args) {
		 	llenar_array();	
		 	Recorrer();
	}
}
