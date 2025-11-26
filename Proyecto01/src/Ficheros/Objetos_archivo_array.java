package Ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import clase.CPersona;
import clase.menu;

public class Objetos_archivo_array {
public static Scanner sc=new Scanner(System.in);
	
	public static void crearFichero(File fichero , boolean añadir) throws FileNotFoundException, IOException {
		ArrayList<CPersona> lista=new ArrayList<CPersona>();
		
		ObjectOutputStream oos=null;
		String respuesta;
		String nombre,direccion;
		long telefono;
		try {
			if (!añadir) {
				oos= new ObjectOutputStream(new FileOutputStream(fichero));	
			}else {
				//Es true cuando queramos añadir es importante sobrescribir el metodo
				oos= new ObjectOutputStream(new FileOutputStream(fichero,true)) {
					protected void writeStremHeader()throws IOException{reset();}
				};
			}
			do {
				System.out.println("Dime el nombre"); nombre=sc.nextLine();
				System.out.println("Dime la direccion"); direccion=sc.nextLine();
				System.out.println("Dime el telefono"); telefono=Long.valueOf(sc.nextLine()) ;
				lista.add(new CPersona(nombre,direccion,telefono));
				
				System.out.println("Quiere continuar añadiendo registros?");
				respuesta=sc.nextLine();
				
			} while (respuesta.equalsIgnoreCase("SI"));
			oos.writeObject(lista);
		}finally {
			oos.close();
		}
	}
	
	public static void mostrarFichero(File fichero) {
		ArrayList<CPersona>aux=null;
		//Esto garantiza que el recurso (ois) se cerrará automáticamente 
		//al finalizar el bloque, incluso si ocurre una excepción. 
		//Es más seguro y limpio que usar finally { ois.close(); }.

		//- En este contexto, los datos entran al programa 
		//desde una fuente externa (como un archivo).

		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero))){
			do {
				//leemos el contenido y lo metemos al ArrayList
				 aux=(ArrayList<CPersona>)ois.readObject();
				if (aux instanceof ArrayList<CPersona>)for(CPersona item:aux) System.out.println(aux);

			} while (true);
			//lo hace hasta que ya no halla mas por leer while (true)
			
		}catch(EOFException ex) {
			System.out.println("Fin del fichero");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public static void leer() throws IOException{
		sc.nextLine();
		File fichero=null;
		String nombreFichero=null,respuesta;
		
		System.out.println("Indique el nombre del fichero");
		nombreFichero=sc.nextLine();
		fichero=new File(nombreFichero);
		
		if (fichero.exists()) {
			mostrarFichero(fichero);
		}else {
			System.out.println("El fichero "+nombreFichero+" no existe");
		}
	}
	
	public static void crear() throws IOException{
		sc.nextLine();
		File fichero=null;
		String nombreFichero=null,respuesta;
		try {
			System.out.println("Indique el nombre del fichero");
			nombreFichero=sc.nextLine();
			fichero=new File(nombreFichero);
			if (fichero.exists()) {
				System.out.println("EL fichero existe.¿Quiere usted añadir registros");
				respuesta=sc.nextLine();
				if (respuesta.equalsIgnoreCase("SI")) {
					crearFichero(fichero, true);
				}
			}else {
				crearFichero(fichero, false);
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	 public static void main(String[] args) throws IOException {
		String[] opciones= {"1.-Crear fichero","2.-Leer Fichero","3.-Salir"};
		
		int op=0;
	
		String basura;
		do {
			op= menu.menu(sc, opciones);
				switch (op) {
		case 1: {
			crear();
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
