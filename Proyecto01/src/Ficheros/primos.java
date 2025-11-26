package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class primos {
	
	
	public static boolean es_primo(int num) {
		for (int i = 2; i < num; i++)if(num%i==0)return false; 	
		return true;
	}
	
	public static void main(String[] args) throws IOException  {	
		try (
			 BufferedWriter bw=new BufferedWriter(new FileWriter("primos.dat"));
			){
				
			for (int i = 2; i <=500; i++)if(es_primo(i))bw.write(i+"\n");
			
			}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado"+e);
			}
		 
	}

} 
//pedir el numero de niveles de una piramide y grabar en un fichero la piramide
