package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Ej92 {

	public static void main(String[] args) {
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAnuevo");
		EntityManager em=emp.createEntityManager();
		EntityTransaction transaccion=em.getTransaction();
		transaccion.begin();
		Alumno a=em.find(Alumno.class,"111");
		System.out.println(a);
		if(a!=null) {
			em.remove(a);
		}else {
			System.out.println("No existe");
		}
		em.merge(new Alumno("12121oo51","Fabian","Luna",90));
		transaccion.commit();
		em.close();
	}
}
