package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ej01 {

	public ej01() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAscott");
		EntityManager em=emp.createEntityManager();
		EntityTransaction transaccion=em.getTransaction();
		transaccion.begin();
		em.persist(new dept(50,"Ventas","Bilbao"));
		em.persist(new dept(60,"Produccion","Bilbao"));

		transaccion.commit();
		em.close();
	}

}
