package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class buscar_caracter {
	public static void main(String[] arg) throws IOException  {
		
		String linea1="";
		
		try (
				BufferedReader br1=new BufferedReader(new FileReader(arg[0]));
			){
				
				linea1=br1.readLine();
	
				
				while(linea1!=null) {
					if (linea1.indexOf(arg[1])!=-1) {
						System.out.println(linea1.substring(linea1.indexOf(arg[1])));
					}
					linea1=br1.readLine();
				}
			
				
			}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado"+e);
			}
		 
	}
}
