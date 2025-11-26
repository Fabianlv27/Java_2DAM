package clases;

public class Televisor extends Electrodomestico {

	private double resolucion;
	private boolean sintonizador_TDT;
	
	
	
	public Televisor() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Televisor(double precio_base, double peso, String color, char consumo_energetico) {
		super(precio_base, peso, color, consumo_energetico);
		// TODO Auto-generated constructor stub
	}



	public Televisor(double precio_base, double peso) {
		super(precio_base, peso);
		this.resolucion=20;
		this.sintonizador_TDT=false;
		
	}
	

	public Televisor(double resolucion,boolean sintonizador_TDT) {
		super();
		this.resolucion = resolucion;
		this.sintonizador_TDT = sintonizador_TDT;
	}


	

	public double getResolucion() {
		return resolucion;
	}



	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}



	public boolean isSintonizador_TDT() {
		return sintonizador_TDT;
	}



	public void setSintonizador_TDT(boolean sintonizador_TDT) {
		this.sintonizador_TDT = sintonizador_TDT;
	}



	@Override
	public void precioFinal() {
		if (this.resolucion >=40) {
			this.precio_base+=this.precio_base*0.3;
		}
		if (sintonizador_TDT) {
			this.precio_base+=50;
		}

	}

}
