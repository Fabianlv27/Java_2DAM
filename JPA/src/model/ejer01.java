package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ejer01 {

	public ejer01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("EjemploJPA");
		EntityManager em=emp.createEntityManager();
		EntityTransaction transaccion=em.getTransaction();
		
		TypedQuery<Alumno>consulta=(TypedQuery<Alumno>)em.createNamedQuery("Alumno.findAll");
		
		List<Alumno> lista=consulta.getResultList();
		
		for (Alumno a : lista) {
			System.out.println(a);
		}
		em.close();
	}

}
