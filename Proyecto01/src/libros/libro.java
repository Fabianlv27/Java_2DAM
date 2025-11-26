package libros;

import java.io.Serializable;
import java.time.LocalDate;

public class libro implements Serializable {
	private String nombre;
	private String autor;
	private LocalDate fecha;
	public libro(String nombre, String autor, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.fecha = fecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "libro [nombre=" + nombre + ", autor=" + autor + ", fecha=" + fecha + "]";
	}
	
	
}
