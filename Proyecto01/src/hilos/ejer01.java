package hilos;

public class ejer01 {
	private static short num=100;
	public static void main(String[] args) {
		Thread h1=new Thread(new ejer01().new RunnableImpl());
		Thread h2=new Thread(new ejer01().new RunnableImpl());
		
		h2.setName("hilo 2");
		h2.start();
		
		h1.setName("hilo 1");
		h1.start();
		System.out.println("Termino el hilo principal");
	}
	public class RunnableImpl implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			num+=100;
			System.out.println(Thread.currentThread().getName()+" ejecutandose, num:"
					+ num);
		}
	}
}
