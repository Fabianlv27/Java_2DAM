package primero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class fichero {
	
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> lista=new ArrayList<Integer>();
		try (
			BufferedReader br=new BufferedReader(new FileReader("numeros.dat"));
		 BufferedWriter bw=new BufferedWriter(new FileWriter("numero_sort.dat"));
		){
			String linea="";
			linea=br.readLine();
			while (linea!=null) {
			System.out.println(linea);
			lista.add(Integer.valueOf(linea));
			linea=br.readLine();
				
			}
			Collections.sort(lista);
			
			for(Integer item:lista) {
				bw.write(item+"\n");
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		
		 
	}
}
