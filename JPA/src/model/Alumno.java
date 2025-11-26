package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



@Entity
@NamedQuery(name="Alumno.todos",query="Select d from Alumno d")

public class Alumno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id	
	String dni;
	String nombre;
	String apellidos;
	int edad;
	
	@OneToMany(mappedBy="alumno",cascade= {CascadeType.PERSIST})
	List<Cursos> cursos=new ArrayList<Cursos>();
	public Alumno() {
		super();
	}

	public Alumno(String dni, String nombre, String apellidos, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	
	
	public List<Cursos> getCursos() {
		return cursos;
	}

	public void setCursos(List<Cursos> cursos) {
		this.cursos = cursos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	public void add(Cursos c) {
		this.cursos.add(c);
	}

	@Override
	public String toString() {
		String cadena= "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "\n";
		for(Cursos c:cursos) {
			cadena =cadena + c.getID()+"\n";
		}
		return cadena;
	}
	

}
