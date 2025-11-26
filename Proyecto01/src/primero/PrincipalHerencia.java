package primero;

import java.util.ArrayList;
import primero.redondear;
import clase.*;
import java.util.Scanner;


public class PrincipalHerencia {
	static ArrayList<FiguraGeometrica> figuras=new ArrayList<FiguraGeometrica>();
	public static Scanner sc=new Scanner(System.in);
	
	public static void imprimir(ArrayList<FiguraGeometrica> f) {
		for(FiguraGeometrica e:f) {
			if(e instanceof cubo) {
			System.out.println("Volumen: "+ ((cubo) e).volumen() );	
			}else {
				System.out.println("Area: "+ e.area());
			}
			System.out.println("Perimetro: "+ e.perimetro());
			
			
		}
	}
	
	public static void Listar() {
		System.out.println(figuras);
	}
	
	public static int ListarClases(boolean ask) {
		System.out.println("\n1.-cuadrado\n2.-rectangulo\n3.-circulo\n4.-triangulo\n5.-salir");
		if(ask) {
		int op=sc.nextInt();
		return op;
		}
		return 0;
		
	}
	
public static void PedirLiteral() {
	System.out.println("*/*/*//*Mostrar Literal*/*/*/*/*/");
	System.out.println("Elije que clases ver:");
	ArrayList<String> Figuras_para_Mostrar=new ArrayList<String>();
	
	int seguir=0;
	
	while(seguir==0) {
		int dato=ListarClases(true);
		
		switch (dato) {
		case 1: {
			if(!Figuras_para_Mostrar.contains("cuadrado")) {
				Figuras_para_Mostrar.add("cuadrado");
			}
		
		break;
		}   
				
		
		case 2: {
			if(!Figuras_para_Mostrar.contains("rectangulo")) {
				Figuras_para_Mostrar.add("rectangulo");
			}
			break;
			}
		case 3: {
			if(!Figuras_para_Mostrar.contains("circulo")) {
				Figuras_para_Mostrar.add("circulo");
			}
			break;
			}
		case 4: {
			if(!Figuras_para_Mostrar.contains("triangulo")) {
				Figuras_para_Mostrar.add("triangulo");
			}
			break;
			}
		case 5:{
			seguir=1;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + dato);
		}
		System.out.println("Elegir otro?");
		
	}
	
	for(FiguraGeometrica fig:figuras) {
		if(Figuras_para_Mostrar.contains(fig.getClass().getSimpleName())) {
			System.out.println(fig);
		}
	}
	
	
	
}
	
public static void Añadir() {
	
		System.out.println("*/*/*/*/Añadir Figura*/*/*/*/*/");
		System.out.println("Que figura quieres añadir?");
		int op= ListarClases(true);
	
		
			switch (op) {
			case 1: {
				System.out.println("Añadir Cuadrado");
				System.out.println("Lado: ");
				double dato=sc.nextInt();
				figuras.add(new cuadrado(dato));
				break;
			}
			case 2: {
				System.out.println("Añadir rectangulo");
				System.out.println("Lado mayor: ");
				double dato=sc.nextInt();
				System.out.println("Lado menor: ");
				double dato2=sc.nextInt();
				figuras.add(new rectangulo(dato,dato2));
				break;
			}
			case 3: {
				System.out.println("Añadir circulo");
				System.out.println("Radio: ");
				double dato=sc.nextInt();
				figuras.add(new circulo(dato));
				break;
			}
			case 4: {
				System.out.println("Añadir Triangulo");
				System.out.println("Base: ");
				double dato=sc.nextInt();
				System.out.println("Altura: ");
				double dato2=sc.nextInt();
				figuras.add(new triangulo(dato,dato2));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
			}
		
	}

public static void main(String[] args) {
	
	figuras.add(new circulo(10));
	figuras.add(new rectangulo(10,20));
	figuras.add(new rectangulo(15,20));
	figuras.add(new triangulo(10,5));
	figuras.add(new cuadrado(2));
	figuras.add(new cubo(4));
	
	 imprimir(figuras);
	int opcion;
	String basura;
	boolean seguir=true;
	String[] opciones= {"1.-Añadir figura",
			"2.-Listar","3.-Literal","4.-Salir"};
	
	while(seguir) {
		opcion=menu.menu(sc,opciones);
		switch (opcion) {
	case 1: {
		Añadir();
		break;
	}
	case 2: {
		Listar();
		break;
	}
	case 3: {
		PedirLiteral();
		break;
	}
	case 4: {
		seguir=false;
		break;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + opcion);
	}
		if (opcion!=4) {
			sc.nextLine();
			System.out.println("Pulse cualquier tecla para continuar:");
			basura=sc.nextLine();
		}
	}
	
}
}


//nos pida la nota del 1er trimestre y la final q queremos alcanzar
//queremos saber que nota tenemos que sacar en el el segundo
//para obtener la final, teniendo en cuenta que la nota del
//primero cuenta un 40%

//añadir, listar,pedir y literal al cual accederemos
//y pondremos ,rect,circulo
//de tal manera que nos muestre esas figuras,salir.
