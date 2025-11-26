package ProductoresConsumidores2;

public class PrincipalProductoConsumidor2 {

public static void main(String[] args) {
	Buffer b=new Buffer(10);
	(new Productor(b)).start();
	(new Consumidor(b)).start();
}

}
