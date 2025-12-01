package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Cliente;
import model.Producto;

public class ej01 {

	public static void main(String[] args) {
		
		Cliente juan=new Cliente("juan");
		Cliente maria=new Cliente("maria");
		Producto vaca=new Producto("vaca");
		
		juan.AddProducto(vaca);
		maria.AddProducto(vaca);
		
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("Tienda_JPA");
		EntityManager em=emp.createEntityManager();
		EntityTransaction transaccion=em.getTransaction();
		transaccion.begin();
		em.persist(vaca);
		em.persist(juan);
		em.persist(maria);
		transaccion.commit();
		em.close();
	}
}
