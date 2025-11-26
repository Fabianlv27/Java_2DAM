package clase;
import java.util.ArrayList;
import java.util.Objects;

public class persona {
	private String nombre;
	private String apellido;
	private int edad;
	
	public persona(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	//Metodos
	public static void getEdadByName(ArrayList<persona> personas,String Name,String Apellido) {
		persona p=new persona(Name,Apellido,0);
		if(personas.contains(p)) {System.out.println("Persona encontrada,"
		+ Name +" "+ Apellido+
		" tiene: "+personas.get(personas.indexOf(p)).getEdad()+ " años");}
		else {System.out.println("No se encontro a " + Name);}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "\n[\nnombre:"
	+ nombre + 
	", \napellido:"
	+ apellido + ", "
	+ "\nedad:" + edad + 
	"\n]\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre,apellido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		persona other = (persona) obj;
		return Objects.equals(apellido,other.apellido) && Objects.equals(nombre, other.nombre);
	}
	
	//diccionario de es -> en mandamos en español y retornamos la traduccion y preguntar si quiere mas palabras
	
}
