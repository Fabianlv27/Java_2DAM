package ProductoresConsumidores2;

public class Productor extends Thread {
	private Buffer buffer;
	
 	public Productor(Buffer buffer) {
		super();
		this.buffer = buffer;
	}

	public Productor() {
		// TODO Auto-generated constructor stub
	}
	private int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			for (int i = 0; i < 10; i++) {
				buffer.producir(alea(500,5000));
				sleep((int)(Math.random()*1000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
