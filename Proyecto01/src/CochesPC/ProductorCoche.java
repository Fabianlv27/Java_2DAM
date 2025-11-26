package CochesPC;

public class ProductorCoche extends Thread {
private BufferCoches buffer;

String[] matriculas = {
        "AAA888", "BAA888", "ACA888", "AAD888", "AAA788",
        "AAA898", "AAA885", "BAA885", "ARA885", "UAA888"
    };


	public ProductorCoche(BufferCoches buffer) {
	super();
	this.buffer = buffer;
}
	private int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}

	public ProductorCoche() {
		// TODO Auto-generated constructor stub
	}
	@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		for (int i = 0; i < matriculas.length; i++) {
			try {
					buffer.Producir(new Coche(matriculas[i],"Toyota","AAAAA"));
					sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
							
		}

	
}
