package interBloqueo;

public class Inicio {

	public static void main(String[] args) {
		Cuenta c1=new Cuenta(12500,"1111");
		Cuenta c2=new Cuenta(12400,"2222");
		
			Hilo h1=new Hilo(c1,c2,"H1");
	Hilo h2=new Hilo(c2,c1,"H2");
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Saldo final c1=%d c2=%d\n",
				c1.getSaldo(),c2.getSaldo()
				);
	}


}
