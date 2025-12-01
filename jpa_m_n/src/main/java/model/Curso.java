package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private double duracion;

	private String titulo;

	//bi-directional many-to-many association to Alumno
	@ManyToMany
	@JoinTable(
		name="alumnocurso"
		, joinColumns={
			@JoinColumn(name="curso_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Alumno_DNI")
			}
		)
	private List<Alumno> alumnos;

	public Curso() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getDuracion() {
		return this.duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}