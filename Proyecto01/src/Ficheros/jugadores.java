package Ficheros;

import java.util.HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.ArrayList;

public class jugadores {
	
	static HashMap<String,ArrayList<String>> equipos =new HashMap<String,ArrayList<String>>();
	
	
	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	public static void Crear_Archivos(String nombre,String data)throws IOException {
		try(
				BufferedWriter bw=new BufferedWriter(new FileWriter("./equipos/"+nombre+".csv",true));
				){
			bw.write(data);
		}
		
	}
	
	public static void Crear_by_Hash()throws IOException {
		for(Entry<String, ArrayList<String>> eq:equipos.entrySet()) {
			try(
					BufferedWriter bw=new BufferedWriter(new FileWriter("./equipos/"+eq.getKey()+".csv",true));
					){
				
				for(String j:eq.getValue()) {
					bw.write(j);
				}
				
				
			}
		}
		
	}
	
	public static void Separar_Equipos() throws IOException  {
		String linea1="";
		
		try (
				BufferedReader br1=new BufferedReader(new FileReader("jugadores.csv"));
			){
				
				linea1=br1.readLine();	
				while(linea1!=null) {
					String Equipo=linea1.split(",")[7];
					Crear_Archivos(Equipo, linea1);
					if (!equipos.containsKey(Equipo)) {
						equipos.put(Equipo, new ArrayList<String>());
					}
					ArrayList<String> nuevo=equipos.get(Equipo);
					nuevo.add(linea1);
					equipos.put(Equipo, nuevo);
					
					linea1=br1.readLine();
				}
				
				
			}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado"+e);
			}
		 
	}
	
	public static void main(String[] args)throws IOException {
		Separar_Equipos();
	}
	
	//leer una sola vez el fichero y nos cree para cada equipo que 
	//hay en ese fichero 
}
