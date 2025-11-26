package Baraja;

public class carta {
	protected String palo;
	protected Integer numero;
	
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	public carta(String palo, Integer numero) {
		super();
		this.palo = palo;
		this.numero = numero;
	}
	@Override
	public String toString() {
	    String valor;
	    String simboloPalo;

	    // Nombre o emoji según el número
	    switch (numero) {
	        case 1:  valor = "As"; break;
	        case 10: valor = "🧝"; break;  // Sota
	        case 11: valor = "🐎"; break;  // Caballo
	        case 12: valor = "👑"; break;  // Rey
	        default: valor = String.valueOf(numero); break;
	    }

	    // Símbolo del palo
	    switch (palo.toLowerCase()) {
	        case "oros":    simboloPalo = "♦"; break;
	        case "copas":   simboloPalo = "🍷"; break;
	        case "espadas": simboloPalo = "⚔"; break;
	        case "bastos":  simboloPalo = "🌿"; break;
	        default:        simboloPalo = "?"; break;
	    }

	    // Construcción visual (ancho fijo de 17 columnas)
	    String lineaSuperior = "┌───────────────┐";
	    String lineaInferior = "└───────────────┘";
	    String lineaTop      = String.format("│ %-13s │", valor); // arriba izquierda
	    String lineaVacia    = "│               │";
	    String lineaCentro   = String.format("│      %-2s       │", simboloPalo); // centrado
	    String lineaBottom   = String.format("│%13s  │", valor);  // abajo derecha

	    return String.join("\n",
	        lineaSuperior,
	        lineaTop,
	        lineaVacia,
	        lineaCentro,
	        lineaVacia,
	        lineaBottom,
	        lineaInferior
	    );
	}

	
	
}
