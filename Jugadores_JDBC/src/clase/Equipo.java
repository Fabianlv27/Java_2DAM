package clase;

public class Equipo {
	String nombre;
	int puntos;
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.puntos = 0;
	}
	public Equipo(String nombre,int puntos) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void SumarPuntos(int cantidad) {
		this.puntos+=cantidad;
	}
	
	
	
}
