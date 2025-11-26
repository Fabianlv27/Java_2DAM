package primero;
 import java.util.Iterator;
import java.util.Scanner;
 
public class matriz {
	
	
	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
		public static Scanner sc=new Scanner(System.in);
		
	public static void PreguntarMedidas() {
		
		System.out.println("Cuantas filas?:");
		int filas=sc.nextInt();
		System.out.println("Cuantas columnas papi?:");
		int col=sc.nextInt();
		
		Rellenar(filas, col);
	
		
	}
	public static void Rellenar(int filas,int col) {
		int[][] TB = new int[filas][col];
		
		for(int i=0;i<TB.length;i++) {
			for(int j=0;j<TB[i].length;j++) {
				TB[i][j]=alea(0,10);
				
			}
		}
		
		Imprimir(TB);
		SumarCol(TB);
		SumarFila(TB);
	}
	
	public static void Imprimir(int[][] TB) {
		for(int i=0;i<TB.length;i++) {
			for(int j=0;j<TB[i].length;j++) {
				System.out.print(TB[i][j] +"\t");
				
			}
			System.out.println("");
		}
	}
	
	public static void SumarFila(int[][] TB) {
		System.out.println("");
		int tfila=0;
		
		for(int i=0;i<TB.length;i++) {
			for(int j=0;j<TB[i].length;j++) {
				tfila+=TB[i][j];
			}
			System.out.print("\nLa suma de la columna"
					+ " "+ (i+1)+" es: "+tfila);
			
			System.out.print(" MEDIA: "+ 
			((double)tfila/TB[i].length));
			
			tfila=0;
		}
	}
	

	public static void SumarCol(int[][] TB) {
		System.out.println("");
		int tcol=0;
		
		for(int i=0;i<TB[0].length;i++) {
			
			for(int j=0;j<TB.length;j++) {
				tcol+=TB[j][i];
			}
			
			System.out.print("\nLa suma de la columna"
					+ " "+ (i+1)+" es: "+tcol);
			
			System.out.print(" MEDIA: "+ 
					((double)tcol/TB.length));
			
			tcol=0;
		}
	}
	
	
	
	
	
public static void main(String[] args) {
	//media por fila y columna 
	PreguntarMedidas();
}
}
