package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class EJ12 {

	public static void main(String[] args) {
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAnuevo");
		EntityManager em=emp.createEntityManager();
		
		Query suma=em.createQuery("select sum(c.Precio) from Cursos c");
		Double total =(Double) suma.getSingleResult();
		System.out.println(total);
		em.close();
	}
}
