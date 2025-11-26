package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ej2 {

	public static void main(String[] args) {
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAscott");
		EntityManager em=emp.createEntityManager();
		EntityTransaction transaccion=em.getTransaction();
		transaccion.begin();
		TypedQuery<String>consulta=em.createQuery("Select d.DNAME from dept d where d.LOC like:loc",String.class);
		consulta.setParameter("loc", "MADRID");
		
		
		List<String> lista= consulta.getResultList();
		
		for (String dp : lista) {
			System.out.println("DNAME:"+dp);
		}
		
		transaccion.commit();
		em.close();
	}

}
