package Principal;
import java.util.Scanner;

public class menu {
	public static int menu(Scanner sc,String[] ops) {
		int op;
			for(String items:ops)System.out.println(items);
			System.out.println("Elige una opcion");
			op=sc.nextInt();

		return op;
	}
}

