package libros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import clase.menu;

public class libros {
	 
		public static Scanner sc=new Scanner(System.in);
		
	public static void añadirLibro(File f,boolean añadir) {
		ArrayList<libro> biblioteca = new ArrayList<libro>();
		
		//Esta es una clase de objeto serealizable
		ObjectOutputStream oos=null;
		String respuesta;
		String nombre,autor;
		LocalDate fecha;
		
		try {
			if (!añadir) {
				//Aqui creamos un nuevo objeto serealizable a partir del contenido 
				//de un nuevo archivo serealizable
				oos=new ObjectOutputStream(new FileOutputStream(f));
				//no colocamos true por que queremos que lo sobreescriba
			}else {
				oos=new ObjectOutputStream(new FileOutputStream(f,true)) {
					protected void writeStremHeader()throws IOException{reset();}
				};
			}
			//una vez definimos si el archivo sera sobreescrito o no, pedieremos los
			//datos del libro
			do {
				System.out.println("Dime el nombre"); nombre=sc.nextLine();
				System.out.println("Dime el autor"); autor=sc.nextLine();
				System.out.println("Dime la fecha yyyy-mm-dd"); fecha= LocalDate.parse(sc.nextLine())  ;
				//Añadimos el objeto al arraylist
				biblioteca.add(new libro(nombre,autor,fecha));
				
				
				System.out.println("Quiere continuar añadiendo registros?");
				respuesta=sc.nextLine();
				
			} while (respuesta.equalsIgnoreCase("SI"));
			
			//metemos el arraylist con todos los libros en el archivo serealizable
				oos.writeObject(biblioteca);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	public static void leerLibros(File f) {
		ArrayList<libro> aux=null;
		
		//Esto garantiza que el recurso (ois) se cerrará automáticamente 
		//al finalizar el bloque, incluso si ocurre una excepción. 
		//Es más seguro y limpio que usar finally { ois.close(); }.

		//- En este contexto, los datos entran al programa 
		//desde una fuente externa (como un archivo).
		
		try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream(f))) {
			do {
			aux=(ArrayList<libro>) ois.readObject();
			if(aux instanceof ArrayList<libro>)for(libro l : aux)System.out.println(l);
			
			} while (true);
			//lo hace hasta que ya no halla mas por leer while (true)
			//cuando no hay mas lanza la excepcion EOFException, se termina el
			//bucle y va al catch
	
		}catch(EOFException ex) {
			System.out.println("fin del archivo");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void añadir() throws IOException {
		sc.nextLine();
		String respuesta;
		String nombre;
		File f;
		System.out.println("Dime el nombre del archivo");
		nombre=sc.nextLine();
		f=new File(nombre);
		if (f.exists()) {
			System.out.println("El fichero existe desea añadir?");
			respuesta=sc.nextLine();
			
			if (respuesta.equalsIgnoreCase("SI")) {
				añadirLibro(f, true);
			}else {
				añadirLibro(f, false);
			}
		}else {
			añadirLibro(f, false);
		};
	}
	public static void leer() throws IOException {
		sc.nextLine();

		String respuesta;
		String nombre;
		File f;
		System.out.println("Dime el nombre del archivo");
		nombre=sc.nextLine();
		f=new File(nombre);
		if (f.exists()) {
		leerLibros(f);
		}else {
			System.out.println("Archivo no existente :( ");
		};
	}
		
	public static void main(String[] args) throws IOException{
String[] opciones= {"1.-Crear fichero","2.-Leer Fichero","3.-Salir"};
		
		int op=0;
	
		String basura;
		do {
			op= menu.menu(sc, opciones);
				switch (op) {
		case 1: {
			añadir();
			break;
		}
		case 2:{
			leer();
			break;
		}
		
		} if (op!=opciones.length) {
			System.out.println("Presione una tecla para continuar");
			basura=sc.nextLine();
		}
	
		
	}while (op!=opciones.length);
	}
}
