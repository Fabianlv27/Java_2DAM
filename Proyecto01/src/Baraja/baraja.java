package Baraja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class baraja {
	static String[] palos={"Oros","Copas","Espadas","Bastos"};
	static ArrayList<carta> mazo= new ArrayList<carta>();
	static carta[] mis_cartas= new carta[15];
	
	public static void Llenar_mazo() {
		for(int i=0;i<palos.length;i++) {
			for (int j = 1; j <=12; j++) {
				mazo.add(new carta(palos[i], j));
			}
		}
	}	
	

	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	public static void Llenar_mis_cartas() {
		for (int i = 0; i < mis_cartas.length; i++) {
			carta new_carta=mazo.get(alea(0,47));
			while( Arrays.asList(mis_cartas).contains(new_carta))new_carta=mazo.get(alea(0,47));
			
			mis_cartas[i]=new_carta;
		}
	}
	
	public static void vizualizar() {
		for(carta c:mis_cartas) {
			System.out.println(c);
		}
	}
	
	
	public static void main(String[] args) {
		Llenar_mazo();
		System.out.println(mazo.size());
		Llenar_mis_cartas();	
		vizualizar();

	}
	
	

}
