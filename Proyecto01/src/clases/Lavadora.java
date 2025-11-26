package clases;

public class Lavadora extends Electrodomestico {
	
	private double carga;

	public Lavadora(double precio_base, double peso) {
		super(precio_base, peso);
		this.carga = 5;
	}
	
	
	public Lavadora() {
		super();
	}
	public Lavadora(double precio_base, double peso,String color, char consumo_energetico,double carga) {
		super( precio_base,  peso,  color,  consumo_energetico);
		this.carga = carga;
	}


	public double getCarga() {
		return carga;
	}


	public void setCarga(double carga) {
		this.carga = carga;
		
	}


	@Override
	public void precioFinal() {
		if (this.carga >=30) {
			this.precio_base+=50;
		}
		
	}
	
	
}
