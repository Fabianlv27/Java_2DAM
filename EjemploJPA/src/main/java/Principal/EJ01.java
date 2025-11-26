package Principal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Alumno;

public class EJ01 {

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
