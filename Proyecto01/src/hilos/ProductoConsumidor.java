package hilos;

public class ProductoConsumidor {

public static void main(String[] args) {
	Panaderia p=new Panaderia();
	new Thread(new Panadero(p)).start();
	new Thread(new Consumidor(p)).start();
	
}

}
