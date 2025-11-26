

import java.util.Scanner;

public class menu {
	public static int menu(Scanner sc,String[] ops) {
		int op;
		do {
			for(String items:ops)System.out.println(items);
			System.out.println("Elige una opcion");
			op=sc.nextInt();
			sc.next();
		} while (op<1 || op>ops.length);
		return op;
	}
}
