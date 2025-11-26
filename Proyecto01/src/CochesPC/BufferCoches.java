package CochesPC;

public class BufferCoches {
private Coche[] buffer;
private int tamaño;
private int contador=0;



	public BufferCoches(int tamaño) {
	super();
	this.tamaño = tamaño;
	this.buffer=new Coche[tamaño];
}


	public BufferCoches() {
		// TODO Auto-generated constructor stub
	}

	public synchronized void Producir(Coche valor) throws InterruptedException {
		if (contador==tamaño) {
			System.out.println("Buffer LLeno, productor esperando.....");
			wait();
		}
		buffer[contador]=valor;
		contador++;
		System.out.println("El productor agrego "+ valor);
		notifyAll();
	}
	public synchronized Coche Consumir() throws InterruptedException {
		if (contador==0) {
			System.out.println("Buffer vacio, Consumidor esperando....");
			wait();
		}
		Coche valor=buffer[--contador];
		System.out.println("EL consumidor ha consumido: "+valor);
		notifyAll();
		return valor;
	}
}
