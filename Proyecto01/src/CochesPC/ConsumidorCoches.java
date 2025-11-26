package CochesPC;

import java.util.Iterator;

public class ConsumidorCoches extends Thread {
private BufferCoches buffer;

	public ConsumidorCoches(BufferCoches buffer) {
	super();
	this.buffer = buffer;
}

	public ConsumidorCoches() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			for (int i = 0; i < 10; i++) {
				try {
					buffer.Consumir();
					sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

}
