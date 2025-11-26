package hilos.casino;

public class JugadorClasico extends jugador {
int numeroElegido;

public JugadorClasico(long saldo, Banca banca) {
	super(saldo, banca);

}

@Override
	public void comunicarNumero(int numero) {
		if (numero==this.numeroElegido) {
			System.out.println(this.nombreHilo+"Gana 36 veces lo jugado. 360$");
			banca.restarSaldo(360);
			sumarSaldo(360);
			
		}
		System.out.println(this.nombreHilo+"tiene un saldo de "+this.saldo);
		this.apuestaRealizada=false;
	}
@Override
	public void hacerApuesta() {
		if (!banca.aceptarApuestas()) {
			return;
		}
		if (apuestaRealizada) {
			return;
		}
		this.numeroElegido=1+generador.nextInt(36);
		banca.SumarSaldo(10);
		restarSaldo(10);
		apuestaRealizada=true;
		banca.aceptarApuesta(this);
		
	}

}
