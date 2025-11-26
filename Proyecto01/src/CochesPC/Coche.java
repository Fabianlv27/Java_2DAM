package CochesPC;

public class Coche {
private String Matricula;
private String Marca;
private String Modelo;



	public String getMatricula() {
	return Matricula;
}



public void setMatricula(String matricula) {
	Matricula = matricula;
}



public String getMarca() {
	return Marca;
}



public void setMarca(String marca) {
	Marca = marca;
}



public String getModelo() {
	return Modelo;
}



public void setModelo(String modelo) {
	Modelo = modelo;
}



	public Coche(String matricula, String marca, String modelo) {
	super();
	Matricula = matricula;
	Marca = marca;
	Modelo = modelo;
}



	public Coche() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Coche [Matricula=" + Matricula + ", Marca=" + Marca + ", Modelo=" + Modelo + "]";
	}

}
