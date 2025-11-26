package clase;
import java.util.ArrayList;
import clase.persona;

public class ej07 {
	
public static ArrayList<persona>Personas=new ArrayList<>();

public static void main(String[] args) {
	
	Personas.add(new persona("Martin","Vizcarra",70));
	Personas.add(new persona("Pedro","Castillo",60));
	Personas.add(new persona("Leonardo","Paredez",19));
	
	System.out.println(Personas);
	
	persona.getEdadByName(Personas,"Leonardo","Paredez");
}

//metodo para pasar el arraylist, el nombre y el apellido
//y nos tiene que devolver si existe la edad.

}
