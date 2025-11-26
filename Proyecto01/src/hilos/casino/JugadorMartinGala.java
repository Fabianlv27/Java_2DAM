package hilos.casino;

public class JugadorMartinGala extends jugador {
	private int cantidadAApostar;
	private int numeroElegido;
	
	public JugadorMartinGala(long saldo, Banca banca) {
		super(saldo, banca);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comunicarNumero(int numero) {
		if(numero==0|| numeroElegido!=numero) {
			System.out.println(nombreHilo+" pierde"+cantidadAApostar);
			cantidadAApostar*=2;
			
		}else if(numeroElegido==numero) {
			banca.restarSaldo(cantidadAApostar*36);
			sumarSaldo(cantidadApostada*36);
			cantidadAApostar=1;
		}
		System.out.println(this.nombreHilo+" queda con un saldo de "+saldo);
	}

	@Override
	public void hacerApuesta() {
		// TODO Auto-generated method stub
		if (!banca.aceptarApuestas()) {
			return;
		}
		if (apuestaRealizada) {
			return;
		}
		numeroElegido=1+generador.nextInt(36);
		banca.SumarSaldo(cantidadAApostar);
		apuestaRealizada=true;
		banca.aceptarApuesta(this);
		
	}
	


}
