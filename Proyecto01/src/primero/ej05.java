package primero;
	 import java.util.Scanner;
public class ej05 {
	
			public static int alea(int li,int ls) {
				return (int)(Math.random()*(ls-li+1))+li;
			}
			
			public static Scanner sc=new Scanner(System.in);
			
	public static boolean isBis(int a) {
		if ((a%4==0 &&a%100!=0 )|| a%400==0) {
			return true;
		}else {
			return false;
		}
		
	}
	 public static void main(String[] args) {
		//numero de mes y el año y nos tiene que decir el nombre del mes
		 //y el numero de dias que tiene y el nombre
		 String[]meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio", "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		 ;
		 //meses con 31:0,2,4,6,7,9,11
		 
		 boolean bis=false;
		 System.out.println("Dame el numero del mes");
		 int mes=sc.nextInt();
		 System.out.println("el mes es: " + meses[mes-1]);
		 
		 System.out.println("Dame el numero del año");
		 int año=sc.nextInt();
		 
		 bis=isBis(año);
		 //otro metodo
		 
		 if ((mes%2!=0 && mes <=7)||(mes%2==0 && mes >=8)) {
			 if (mes==2) {
				 System.out.println(bis?"Tiene 29 dias":"Tiene 28 dias");
				 return;
			}
			System.out.println("31");
		}else {System.out.println("30");}
		 
		 ///////////////////////
		 
		 switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:	
		case 8:
		case 10:
		case 12:
		{
			System.out.println("Tiene 31 dias");
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11:	
		{
			System.out.println("Tiene 30 dias");
			break;
		}
		case 2:{
			System.out.println(bis?"Tiene 29 dias":"Tiene 29 dias");
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + mes);
		}

	}
	 //paquete clase dentro una clase persona dentro tenemos atributos: nom ,apell,edad, contiene construtor con todos los parametros, to string getter and setter
}
