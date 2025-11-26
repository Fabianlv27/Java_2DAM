package ProductoresConsumidores2;

public class Consumidor extends Thread{
	private Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		super();
		this.buffer = buffer;
	}

	public Consumidor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			for (int i = 0; i < 10; i++) {
				buffer.consumir();
				sleep((int)(Math.random()*1000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
//matricula , marca ,modelo, productor  y consumidor de coches
