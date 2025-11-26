package hilos;

public class finalizar_hilo {
	
	public static void main(String[] args)throws InterruptedException {
			Thread workerThread=new Thread(new WorkerTask(),"Trabajo");
	workerThread.start();
	Thread.sleep(2000);
	System.out.println("Hilo prin"
			+ "cipal: Interrumpiendo el hilo de trabajo");
	workerThread.interrupt();
}
	}


class WorkerTask implements Runnable{
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+": Empezando a dormir.....");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()+": Desperte normalmente.");
			
		}catch(InterruptedException e){
			System.out.println(Thread.currentThread().getName() +":Fue interrumpido");
		}finally {
			System.out.println(Thread.currentThread().getName()+":Finalizado");
		}
	}
	
}