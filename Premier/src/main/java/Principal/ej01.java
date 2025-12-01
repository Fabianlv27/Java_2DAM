package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ej01 {
	
	public static void main(String[] args) {
		String lectura="ficheroRead.dat";
		String linea;
		ArrayList<String> lista=new ArrayList<String>();
		
		try(BufferedReader flectura = new BufferedReader(new FileReader(lectura))){
			
			linea=flectura.readLine();
			while(linea!=null) {
				lista.add(linea);
				linea=flectura.readLine();
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
