package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class dos_ficheros {
	
	public static void main(String[] args) throws IOException  {
		
		String linea1="";
		String linea2="";
		
		try (
				BufferedReader br1=new BufferedReader(new FileReader("F1.dat.txt"));
				BufferedReader br2=new BufferedReader(new FileReader("F2.dat.txt"));
			 BufferedWriter bw=new BufferedWriter(new FileWriter("fusion.dat"));
			){
				
				linea1=br1.readLine();
				linea2=br2.readLine();
				
				while (linea1!=null &&linea2!=null) {
					bw.write(linea1+"\n");
					bw.write(linea2+"\n");
					linea1=br1.readLine();
					linea2=br2.readLine();
				}
				
				while(linea1!=null) {
					bw.write(linea1+"\n");
					linea1=br1.readLine();
				}
				while(linea2!=null) {
					bw.write(linea2+"\n");
					linea2=br2.readLine();
				}
				
			}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado"+e);
			}
		 
	}
}
//generar notas a fisica quimica y mates, separadas : (10;5;4) hacer 50 alumnos en un csv, leyendo 
//crear dos ficheros 1.-Alumnos aprovados todas, 2.-Los que han desaprovado algunas.
