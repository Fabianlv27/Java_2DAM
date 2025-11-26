package primero;
import java.util.HashMap;
import clase.persona;
import java.util.Scanner;
public class hashPersona {
	static HashMap<String,persona> personas=new HashMap<>();

		public static Scanner sc=new Scanner(System.in);
		
	public static void PreguntarDNI(String Dni,Boolean Actualizar) {
		System.out.println(!Actualizar? "Usuario no existe":"Actualizar datos");
		System.out.println("Introduce sus datos:");
		System.out.println("Nombre:");
		String name=sc.nextLine();
		System.out.println("Apellido:");
		String apll=sc.nextLine();
		System.out.println("Edad:");
		int edad=Integer.valueOf(sc.nextLine()) ;
		
		personas.put(Dni, new persona(name,apll,edad));
		System.out.println("Datos agregados correctamente :)");
	}
	

	
	public static void EjDni() {
		int it=0;
		
		while (it==0) {
			
	System.out.println("Introduce el DNI:");
		String DNI=sc.nextLine();
		if (!personas.containsKey(DNI)) {
			PreguntarDNI(DNI,false);
		}else{
			personas.get(DNI);
			System.out.println("Desea modificar los datos?\n(0)SI\n(1)NO");
			int modificar=sc.nextInt();
			sc.nextLine();
			if (modificar==1) {
				break;
			}
			PreguntarDNI(DNI, true);
			System.out.println(personas);
			System.out.println("Desea salir?\n(0)SI\n(1)NO");
			 it =sc.nextInt();
			 sc.nextLine();
			 if (it==0) {
				break;
			}else {
				continue;
			}
			
		}
			
		}
		
	}
	
	public static void main(String[] args) {
		personas.put("09888L", new persona("lolo","lolo",5));
		personas.put("09833x", new persona("Jesus","cristo",2025));
		personas.put("76588y", new persona("Papanoel","lopez",200));
		System.out.println(personas);
		
		EjDni();
	}
	//paso el hashmap,pasar dni, si no existe que me pida los datos relativos 
	//a la persona a incluir y
	//si existe que nos de la opcion de modificar los datos que ya tenemos
}
