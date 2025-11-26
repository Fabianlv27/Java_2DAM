package ProductoresConsumidores2;

public class Buffer {
private int[] buffer;
		private int tamaño;
		private int contador=0;
		
	public Buffer() {

	}

	public Buffer(int tamaño) {
		super();
		this.tamaño = tamaño;
		buffer=new int[tamaño];
		
	}
	/**
	 * @throws InterruptedException ***************************************************/
	public synchronized void producir(int valor) throws InterruptedException {
		while (contador==tamaño) {
			System.out.println("Buffer lleno , el productor esta esperando ");
			wait();	
		}
		buffer[contador]=valor;
		contador++;
		System.out.println("EL productor agrego "+ valor);
		notifyAll(); //Avisa al consumidor que hay un elemento nuevo
		/*************************************************/

	}
			public synchronized int consumir() throws InterruptedException {
			while(contador==0) {
				System.out.println("EL consumidor esta esperando. El buffer esta vacio");
				wait();
			}
			int valor=buffer[--contador];
			System.out.println("EL consumidor cosumio: "+valor);
			notifyAll();
			//Notfica al productor que hay valores por introducir
			return valor;
		}
	
}
