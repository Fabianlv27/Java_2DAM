package hilos;

public class GrandesAlmacenes {
	static int cantidad_clientes=300;
	static almacen a=new almacen(100);
	static Thread[] clientes=new Thread[cantidad_clientes];
	
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < cantidad_clientes; i++) {
			clientes[i]=new Thread( new cliente(a, "Cliente "+(i+1)));
			clientes[i].start();
		}
		

		
		
	}
}

class almacen{
	
	int cantidad=100;
	boolean ocupado=false;

	public synchronized int  getCantidad() {
		return cantidad;
	}
	

	public synchronized boolean isOcupado() {
		return ocupado;
	}


	public synchronized void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}


	public synchronized void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public almacen(int cantidad) {
		super();
		this.cantidad = cantidad;
	}
	
	
	public almacen() {
	}
	public  boolean entrar(cliente c) throws InterruptedException {
		
		if(ocupado) {
			System.out.println(c.getNombre()+" no ha podido entrar por que esta ocupado.");
			c.setIntentos(c.getIntentos()+1);;
		return false;	
		}
	//	wait();
		ocupado=true;
		//notifyAll();
		System.out.println(c.getNombre()+" Ha entrado.");
		
		
		if(cantidad<=0) {
			ocupado=false;
		System.out.println(c.getNombre()+" No ha encontrado producto.");
		return true;	
		}
		
		System.out.println(c.getNombre()+" ha encontrado producto y lo compra.");
		cantidad--;
		ocupado=false;
		System.out.println(c.getNombre()+" Ha salido.");
		return true;
	}
	
	
}

class cliente implements Runnable{
	
	String nombre;
	int intentos=0;
	almacen a;
	
	
	public int getIntentos() {
		return intentos;
	}


	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public cliente(almacen a,String nombre) {
		super();
		this.a = a;
		this.nombre=nombre;
	}

	
	@Override
	public void run() {
		boolean parar=false;
		
		while(this.intentos<10 && !parar ) {
			try {
				parar=a.entrar(this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

