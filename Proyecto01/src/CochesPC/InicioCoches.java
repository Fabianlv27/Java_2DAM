package CochesPC;



public class InicioCoches {

public static void main(String[] args) {
	BufferCoches b=new BufferCoches(10);
	(new ProductorCoche(b)).start();
	(new ConsumidorCoches(b)).start();
}

}
