package clases;

public class Carrera {
	public static void main(String[] args) {
		Object testigo=new Object();
		
		Atleta[] atletas=new Atleta[4];
		
		for (int j = 0; j < atletas.length; j++) {
			atletas[j]=new Atleta("Atleta"+(j+1) ,testigo);
		}
		
		double carrera=0;
		
		for (int i = 0; i < atletas.length; i++) {
		
			atletas[i].start();
		
		synchronized(testigo) {
			try {
				testigo.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		carrera+=atletas[i].getDuracion();
		
		}
		
		System.out.println("Duracion total de la carrera " +carrera+" segundos");
	}
}
