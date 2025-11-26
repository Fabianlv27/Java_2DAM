package tabla;

import java.time.LocalDateTime;

public class Empleado {
	private int id;
	private String nombre;
	private double salario;
	private LocalDateTime fecha;
	/////////////////////////////////////////////////////////////////////////////
	public Empleado(int id ,String nombre, double salario, LocalDateTime fecha) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.salario = salario;
		this.fecha = fecha;
	}
/////////////////////////////////////////////////////////////////////////////
public Empleado( String nombre, double salario, LocalDateTime fecha) {
	super();
	this.id=id;
	this.nombre = nombre;
	this.salario = salario;
	this.fecha = fecha;
}
	/////////////////////////////////////////////////////////////////////////////////
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	//////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
	    return String.format(
	        "🧾 Empleado\n" +
	        "───────────────\n" +
	        "🆔 ID      : %d\n" +
	        "👤 Nombre  : %s\n" +
	        "💰 Salario : %.2f\n" +
	        "📅 Fecha   : %s\n",
	        id, nombre, salario, fecha
	    );
	}
	
}
