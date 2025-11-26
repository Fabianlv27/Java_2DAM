package Ficheros;

import java.util.HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;

public class provincia {
static HashMap<String,ArrayList<String>> provincias =new HashMap<String,ArrayList<String>>();
	
	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	public static void Crear_Archivos(String nombre,String data)throws IOException {
		try(
				BufferedWriter bw=new BufferedWriter(new FileWriter("./provincias/"+nombre+".csv",true));
				){
			bw.write(data);
		}
		
	}
	
	public static void Crear_by_Hash()throws IOException {
		for(Entry<String, ArrayList<String>> eq:provincias.entrySet()) {
			try(
					BufferedWriter bw=new BufferedWriter(new FileWriter("./equipos/"+eq.getKey()+".csv",true));
					){
				
				for(String j:eq.getValue()) {
					bw.write(j);
				}
				
				
			}
		}
		
	}
	
	public static void Separar_Provincias() throws IOException  {
		String linea1="";
		
		try (
				BufferedReader br1=new BufferedReader(new FileReader("PROVINCIAS.csv"));
			){
				
				linea1=br1.readLine();	
				while(linea1!=null) {
					String[] provincia=linea1.split(",");
					Crear_Archivos(provincia[0], linea1);
					if (!provincias.containsKey(provincia[0])) {
						provincias.put(provincia[0], new ArrayList<String>());
					}
					ArrayList<String> nuevo=provincias.get(provincia[0]);
					nuevo.add(provincia[1]);
					provincias.put(provincia[0], nuevo);
					
					linea1=br1.readLine();
				}
				
				
			}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado"+e);
			}
		 
	}
	
	public static void main(String[] args)throws IOException {
		Separar_Provincias();
		Crear_by_Hash();
	}
}
//escribe un programa que guarde en un fichero primos.dat los n primos que hay entre uno y quinentos