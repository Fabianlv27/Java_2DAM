package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Cursos.todos",query="Select d from Cursos d")
public class Cursos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String ID;
	private String Titulo;
	private int Duracion;
	private double Precio;

	@ManyToOne
	@JoinColumn(name="Alumno_dni")
	private Alumno alumno;
	
	public Cursos() {

	}
	

	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno=alumno;
		alumno.getCursos().add(this);
	}
	public Cursos(String iD, String titulo, int duracion, double precio, Alumno alumno) {
		super();
		ID = iD;
		Titulo = titulo;
		Duracion = duracion;
		Precio = precio;
		setAlumno(alumno);
	}

	@Override
	public String toString() {
		return "Cursos [ID=" + ID + ", Titulo=" + Titulo + ", Duracion=" + Duracion + ", Precio=" + Precio + ", alumno="
				+ alumno + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Duracion, ID, Precio, Titulo, alumno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cursos other = (Cursos) obj;
		return Duracion == other.Duracion && Objects.equals(ID, other.ID)
				&& Double.doubleToLongBits(Precio) == Double.doubleToLongBits(other.Precio)
				&& Objects.equals(Titulo, other.Titulo) && Objects.equals(alumno, other.alumno);
	}

}
