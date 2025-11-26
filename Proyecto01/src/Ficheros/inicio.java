package Ficheros;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import clases.CListaTelefonos;
import clases.CPersona;

public class inicio {
public static Scanner sc=new Scanner(System.in);
static int pos;
static boolean eliminados=false;


public static void buscar(CListaTelefonos lis)throws IOException{
	String nombre;
	System.out.println("Nombre: ");nombre=sc.nextLine();
	pos= lis.Buscar(nombre, 0);
	System.out.println(lis.valorEn(pos));
	
}

public static void buscarSiguiente(CListaTelefonos lis)throws IOException{
	if (pos+1<lis.getNregs()) {
	pos++;
	}else {
		pos=0;
	}
	System.out.println(lis.valorEn(pos));
	
}
public static void Modificar(CListaTelefonos lis)throws IOException{
	System.out.println("*/*/*/*/*/*/Que Modificar?*/*/*/*/*/*/");
	buscar(lis);
	String nombre,direccion;
	long telefono;
	System.out.println("Nuevo Nombre: ");nombre=sc.nextLine();
	System.out.println("Nueva Direccion: ");direccion=sc.nextLine();
	System.out.println("Nuevo Telefono: ");telefono=Long.valueOf(sc.nextLine());
	lis.ponerValorEn(pos, new CPersona(nombre, direccion, telefono));
	System.out.println("Modificado con exito");
	
}


public static void añadirListin(CListaTelefonos lis) throws IOException {
	String nombre,direccion;
	long telefono;
	System.out.println("Nombre: ");nombre=sc.nextLine();
	System.out.println("Nombre: ");direccion=sc.nextLine();
	System.out.println("Telefono: ");telefono=Long.valueOf(sc.nextLine());
	
	lis.añadir(new CPersona(nombre, direccion, telefono));
 }

public static void EliminarCeros(CListaTelefonos lis,File fich) throws IOException {
	
	File fnuevo=new File("listinfn2.dat");
	CListaTelefonos nuevo=new CListaTelefonos(fnuevo);
	for (int i = 0; i < lis.longitud(); i++) {
		if(lis.valorEn(i).getTelefono()!=0)
			nuevo.añadir(lis.valorEn(i));
	}
	lis.cerrar();
	nuevo.cerrar();
	System.out.println(fich);
	fich.delete();
	if (!fnuevo.renameTo(fich)) {
	    throw new IOException("no se renombro");
	}

	
 }


public static void Eliminar(CListaTelefonos lis,File fich) throws IOException {
	System.out.println("*/*/*/*/*/*/Que Eliminar?*/*/*/*/*/*/");
	System.out.println("Telefono: ");long telefono=Long.valueOf(sc.nextLine());
	lis.Eliminar(telefono);
	eliminados=true;
	
 }


public static void listar(CListaTelefonos lis) throws IOException{
 for (int i = 0; i <lis.longitud(); i++) {
	System.out.println(lis.valorEn(i));
}
}

public static void main(String[] args) throws IOException {
	
	
	File fichero=new File("listinfn.dat");
	CListaTelefonos listin=new CListaTelefonos(fichero);
	
	int op;
	String basura;
	String opciones[]= {"1.-Buscar",
			"2.Buscar siguiente",
			"3.-Modificar",
			"4.-Añadir","5.-Eliminar","6.-Listar","7.-Salir"};
	
	do {
		op=biblioteca.menu(sc, opciones);
		switch (op) {
		case 1: 
			buscar(listin);
			break;		
		case 2:
			buscarSiguiente(listin);
			break;
		case 3: 
			Modificar(listin);
			break;	
		case 4:
			añadirListin(listin);
			break;		
		case 5: 
			Eliminar(listin, fichero);
			break;	
		case 6:
			listar(listin);
			break;
		case 7:
			EliminarCeros(listin, fichero);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		
		}
		if (op!=7) {
			System.out.println("pulse una letra para continuar...");
			basura=sc.nextLine();
		}
		//el diablo
		//modificar el fichero con el que trabajar
		//tener un registro de amigos,compra,etc
		//que me pida el fichero y que pueda modificarlo
		
	}while(op!=7);
	

}
}

// clase cRegistro referencia y precio
