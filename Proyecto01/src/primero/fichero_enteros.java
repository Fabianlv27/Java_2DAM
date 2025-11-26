package primero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fichero_enteros {
	
	static String rutaArchivo="lista.txt";
	
	  public static void insertarNumero(int a) {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
	            bw.write(a); // Convierte el objeto en texto
	            bw.newLine(); // Nueva línea para cada objeto
	            System.out.println("Archivo escrito correctamente.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	  
	    public static void leerArchivo() {
	        File file = new File(rutaArchivo);
	        if (!file.exists()) {
	            System.out.println("⚠️ Archivo no encontrado. Creando un archivo vacio...");
	            try {
	                file.createNewFile(); // 🔹 Crea el archivo vacío si no existe
	            } catch (IOException e) {
	                System.out.println("❌ Error al crear el archivo: " + e.getMessage());
	                return; 
	        }
	        }
	        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	            String linea="";
	            linea = br.readLine();
	            while (linea != null) {
	                System.out.println(Integer.valueOf(linea) );
	                linea=br.readLine();
	            }
	        } catch (IOException e) {
	            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
	        }

	    }
	public static void main(String[] args) {
		leerArchivo();
		insertarNumero(1);
		insertarNumero(2);
		insertarNumero(3);
	}
}
