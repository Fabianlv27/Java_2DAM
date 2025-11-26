package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class notas {

	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	public static void RellenarNotas() throws IOException  {
		
		try (

				BufferedWriter bw=new BufferedWriter(new FileWriter("notas.dat"));
			){
				
				for (int i = 1; i <= 50; i++) {
					bw.write("A"+i+":"+alea(0,10)+":"+alea(0,10)+":"+alea(0,10)+"\n ");
				}
				
			}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado"+e);
			}
		 
	}
	
	public static void Aprobados_Suspensos() throws IOException  {
		
		String linea1="";
		
		try (
				BufferedReader br1=new BufferedReader(new FileReader("notas.dat"));
			 BufferedWriter bw1=new BufferedWriter(new FileWriter("aprobados.dat"));
				BufferedWriter bw2=new BufferedWriter(new FileWriter("suspensos.dat"));
			){
				
				linea1=br1.readLine();	
				while(linea1!=null) {
					String[] notas=linea1.split(":");
	
					if(Integer.parseInt(notas[1])>=5 
						&&Integer.parseInt(notas[2])>=5
						&&Integer.parseInt(notas[3])>=5
							) {
						bw1.write(linea1+"\n");
					}else {
						bw2.write(linea1+"\n");
					}
					linea1=br1.readLine();
				}
			
				
			}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado"+e);
			}
		 
	}
	
	public static void main(String[] args)throws IOException {
		RellenarNotas();
		Aprobados_Suspensos();
	}
}
//mostar el nombre del equipo y crear un fichero de nombre "nombre_del_equipo.csv" que contenga los integrantes de este.
