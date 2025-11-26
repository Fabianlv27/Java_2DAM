package primero;

import java.util.Iterator;

public class redondear {
	
	public static double red(double n,int digitos) {
		int exponente=(int)Math.pow(10,digitos);
		return (double)Math.round(exponente*100)/exponente;
	}
	
	public static double truncar(double n,int digitos) {
		double exponente=(double)Math.pow(10,digitos);
		double truncado=(int)(n*exponente)/exponente;
		return truncado;
	}
	public static void main(String[] args) {
		System.out.println(truncar(18.246,2));
	}
}
//clase abstracta figura geometrica cuyo
//atributos sean: dato 1(double),
//dos metodos abstractos area y perimetro;
