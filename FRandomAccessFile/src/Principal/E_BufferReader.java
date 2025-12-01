package Principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;

public class E_BufferReader {
	
public static void main(String[] args) {
	String lectura="FicheroRead.dad";


	Collections.sort(lista,new Comparator<Persona>()
			{
			@Override
			public int compare(Persona o1,Persona o2) {
				int n=-1*(o2.getEdad()-o2.getEdad());
				if(n!=0)return n;
				return -1*(o2.getNombre().compareto(o1.getNombre()));
				
			}
		
			});
	
	String escritura="FicheroRead.dad";
	try(BufferedWriter fescritura=new BufferedWriter(new FileWriter(escritura))){
		File fficheroRead=new File("FicheroRead.dad");
		File fficheroWrite=new File("FicheroRead.dad");
		if (fficheroRead.delete()) {
			System.out.println("fichero Borrado");
			boolean pudo=fficheroWrite.renameTo(fficheroWrite);
			if (pudo) {
				System.out.println("se renombro");
			}else {
				System.out.println("No se renombro");
			}
		}else {
			System.out.println("No se pudo borrar");
		}
	}
//3,7, crear db con equipo:id,nombre, integrantes:id,nombre	

}


}

class Persona{
	String nombre;
	int edad;
	
	
}