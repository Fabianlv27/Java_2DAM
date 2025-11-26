package clases;

import java.util.Arrays;

public abstract class Electrodomestico {
	protected double precio_base;
	protected double peso;
	protected String color;
	protected char consumo_energetico;
	
	
	
	private void comprobarConsumoEnergetico(char letra) {
		char[] letras = {'A', 'B', 'C', 'D', 'E', 'F'};
		if (Arrays.asList(letras).contains(letra)) {
			this.consumo_energetico=letra;
		}
		this.consumo_energetico='F';
		
	}
	
	private void comprobarColor(String color) {
		String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};
		
		if (Arrays.asList(colores).contains(color)) {
			this.color=color;
		}
		this.color="blanco";
	}
	
	public void calcular_precio() {
		int precio=0;
		switch (this.consumo_energetico) {
		case 'A': {
			precio=100;
			break;
		}
		case 'B': {
			precio=80;
			break;
		}
		case 'C': {
			precio=60;
			break;
		}
		case 'D': {
			precio=50;
			break;
		}case 'E': {
			precio=30;
			break;
		}
		case 'F': {
			precio=10;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.consumo_energetico);
		}
		
		if (peso>=0 && peso<=19) {
			precio+=10;
		}else if (peso>=20 && peso<=49) {
			precio+=50;
		}else if (peso>=50 && peso<=79) {
			precio+=80;
		}else if (peso>=80) {
			precio+=100;
		}
		
		this.precio_base+=precio;
		precioFinal();
	}
	
	public abstract void precioFinal();
	
	
	
	public Electrodomestico(double precio_base, double peso, String color, char consumo_energetico) {
		super();
		this.precio_base = precio_base;
		this.peso = peso;
		comprobarColor(color);
		comprobarConsumoEnergetico(consumo_energetico);
		precioFinal();
	}
	
	public Electrodomestico() {
		super();
		this.color="blanco";
		this.consumo_energetico='F';
	}


	public Electrodomestico(double precio_base, double peso) {
		super();
		this.precio_base = precio_base;
		this.peso = peso;
		comprobarColor(color);
		comprobarConsumoEnergetico(consumo_energetico);
		precioFinal();
	}


	public double getPrecio_base() {
		return precio_base;
	}

	public void setPrecio_base(double precio_base) {
		this.precio_base = precio_base;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getConsumo_energetico() {
		return consumo_energetico;
	}

	public void setConsumo_energetico(char consumo_energetico) {
		this.consumo_energetico = consumo_energetico;
	}
	
		
	
	
}
