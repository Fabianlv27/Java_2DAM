package hilos.GrandesAlmacenesSol;

public class GrandesAlmacenesSol {
	public static void main(String[] args) {
		final int N_CLIENTES=300;
		final int N_PRODUCTOS=100;
		
		cliente2[] clientes=new cliente2[N_CLIENTES];
		Almacen2 almacen=new Almacen2(N_PRODUCTOS);
		
		Puerta puerta=new Puerta();
		for (int i = 0; i < N_CLIENTES; i++) {
			clientes[i]=new cliente2(puerta,almacen,"Cliente "+ (i+1));
			clientes[i].start();
		}
	}

}
