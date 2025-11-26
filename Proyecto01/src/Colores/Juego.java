package Colores;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Juego {
	public static Scanner sc=new Scanner(System.in);
	
	static String[] TablaColores={"R","A","V","Z","M","B"};

    static final String[] ColoresANSI = {
        "\u001B[31m", // R - Rojo
        "\u001B[33m", // A - Amarillo
        "\u001B[32m", // V - Verde
        "\u001B[34m", // Z - Azul
        "\u001B[35m", // M - Marrón (usamos magenta como aproximación)
        "\u001B[37m"  // B - Blanco
    };

    static final String RESET = "\u001B[0m";

	static Combinacion C=new Combinacion(TablaColores,4,6,20);
	
	
	public static void Preguntar(String[]combinacionBot) {
		String basura;
		//HashMap<String,Object> response=new HashMap<>();
		int index;
		String[] CombiUser=new String[C.getNumColoresCombinacion()];
		boolean isRight=false;
		int intentos=0;
		HashMap<String,Object> response=new HashMap<>();
		response.put("Positions", new boolean[C.getNumColoresCombinacion()]);
		while(!isRight && intentos<C.getNumIntentos() ) {
			
			
			   
		if(intentos>0) {
			sc.nextLine();
			System.out.println(ColoresANSI[0]+"Combinacion incorrecta"+RESET);
			System.out.println(ColoresANSI[2]+"Colores existentes: "+RESET+response.get("coloresAcertados"));
			System.out.println("Presione cualquier tecla para intentar de nuevo");
			basura=sc.nextLine();
		}
		
	
		for (int i = 0; i <C.getCombi().length ; i++) {
			if(!((boolean[])(response.get("Positions")))[i]) {
					System.out.println("Selecciona un numero del 1--"+(C.getNumColoresJuego()));
			   for (int j = 0; j < TablaColores.length; j++) {
		            System.out.print((j+1)+") "+ColoresANSI[j] + "Color " + TablaColores[j] + RESET+"\t\t");
		        }
			   
			   System.out.println("\n\t\t\t\t\t\t\t");
			for (int j = 0; j < CombiUser.length; j++) {
				System.out.print((CombiUser[j] !=null?ColoresANSI[Arrays.asList(TablaColores).indexOf(CombiUser[j])]+CombiUser[j]:"?")+RESET+(j!=CombiUser.length-1?"---":""));
				
			}
			}
			
		
		
			if(intentos>0 && i!=0) {
				 System.out.println("");
					for (int j = 0; j < CombiUser.length; j++) {
						
						if(j<=i-1 && !((boolean[])(response.get("Positions")))[j]) {
							System.out.print("🔴--");
						}else {
							if(((boolean[])(response.get("Positions")))[j]) {
					System.out.print(ColoresANSI[2]+"✔️--"+RESET);
				}else {
					System.out.print(ColoresANSI[0]+"✖️--"+RESET);
				}						
						}				
			}
				
			}
	System.out.println("");
	
			
			if(!((boolean[])(response.get("Positions")))[i]) {
				System.out.println("Color "+ (i+1)+" : ");
			index=sc.nextInt();
			CombiUser[i]=TablaColores[index-1];
			
			}
			
		}
		response=C.EvaluacionCombinacion(CombiUser);
		isRight=(boolean)response.get("isRight");
		intentos++;
			
		}
		if(isRight) {
			System.out.println("Descubriste la combinacion");
		}else {
			System.out.println("Limite de intentos exedido");
		}
		
	}

	
	public static void main(String[] args) {

		C.GenerarCombinacion();
		Preguntar(C.Combi);
		 
		 
		 
	}
}
