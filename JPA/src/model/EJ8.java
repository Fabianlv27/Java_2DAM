package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class EJ8 {
	public static void main(String[] args) {
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAnuevo");
		EntityManager em=emp.createEntityManager();


		TypedQuery<Alumno> consulta=(TypedQuery<Alumno>) em.createNamedQuery("Alumno.todos");
			;
		for(Alumno a: consulta.getResultList())System.out.println(a);
		
		
		em.close();
	}


}
