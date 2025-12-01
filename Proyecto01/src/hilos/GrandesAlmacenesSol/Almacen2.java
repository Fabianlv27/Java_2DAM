package hilos.GrandesAlmacenesSol;

public class Almacen2 {
	int nProductos=100;
	
	public Almacen2() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Almacen2(int nProductos) {
		super();
		this.nProductos = nProductos;
	}


	public boolean cogerProductos() {
		if (nProductos<=0) {
			return false;
			
		}
		nProductos--;
		return true;
	}
}
