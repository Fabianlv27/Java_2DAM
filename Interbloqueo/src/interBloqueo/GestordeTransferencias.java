package interBloqueo;

public class GestordeTransferencias {
	
	public static boolean transferencia(Cuenta c1,Cuenta c2,int cantidad) {
		Cuenta cuentaMenor,cuentaMayor;
		if(c1.getNumeCuenta().compareTo(c2.getNumeCuenta())<0) {
			cuentaMenor=c1;
			cuentaMayor=c2;
		}
		else {
			cuentaMenor=c2;
			cuentaMayor=c1;
		}
		boolean resultado=false;
		synchronized (cuentaMayor) {
			synchronized (cuentaMenor) {
			if(c1.getSaldo()>=cantidad) {
				c1.sacar(cantidad);
				c2.ingresar(cantidad);
				resultado=true;
			}	
			}
		}
		return resultado;
	}
	
	public GestordeTransferencias() {
		
	}

}
