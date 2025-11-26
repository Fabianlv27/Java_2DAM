package Colores;

import java.util.Arrays;
import java.util.HashMap;

public class Combinacion {
	protected static  int NumColoresCombinacion; /* Número de colores de una combinación */
	protected static  int NumColoresJuego;
	protected static  int NumIntentos;
	protected static String[] TablaColores;
	protected static String[] Combi;
	
	
	public Combinacion(String[] tablaColores,int NComb,int NCol,int NInt) {
		NumColoresCombinacion=NComb;
		NumColoresJuego=NCol;
		NumIntentos=NInt;
		this.Combi=new String[NComb];
		TablaColores = Arrays.copyOf(tablaColores, tablaColores.length);

	}

	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	/***************************/
	public HashMap<String,Object> EvaluacionCombinacion (String[] CombiUser) {
		HashMap<String,Object> response=new HashMap<>();
		
		boolean[] Positions=new boolean[CombiUser.length];
		String coloresAcertados="";
		boolean isRight=true;
		
		if (Combi.length !=CombiUser.length);
		for (int i = 0; i < Combi.length; i++) {
			
			//Comprobar repetidos
			for (int j = 0; j < i; j++) if (CombiUser[j]==CombiUser[i]) return null;
			
			if (Combi[i]==CombiUser[i]) {
				Positions[i]=true;
			}else {Positions[i]=false; isRight=false;}
			
			for (int j = 0; j < Combi.length; j++) if (CombiUser[i]==Combi[j])coloresAcertados+=CombiUser[i] ;
		}
	
		response.put("Positions", Positions);
		response.put("coloresAcertados", coloresAcertados);
		response.put("isRight", isRight);
		return response;
	}
	
	public static void GenerarCombinacion() {
		for (int i = 0; i < NumColoresCombinacion; i++) {
			int num=alea(0,5);
			while(Arrays.asList(Combi).contains(TablaColores[num])) num=alea(0,5);
			Combi[i]=TablaColores[num];
		}
		for (int i = 0; i < Combi.length; i++) {
			System.out.println(Combi[i]);
		}
	}
	
	public String[] getCombi() {
		return Combi;
	}
	public void setCombi(String[] combi) {
		Combi = combi;
	}
	public String[] getTablaColores() {
		return TablaColores;
	}
	public void setTablaColores(String[] tablaColores) {
		TablaColores = tablaColores;
	}
	public int getNumColoresCombinacion() {
		return NumColoresCombinacion;
	}
	public int getNumColoresJuego() {
		return NumColoresJuego;
	}
	public int getNumIntentos() {
		return NumIntentos;
	}
	
	
	
	
	
}