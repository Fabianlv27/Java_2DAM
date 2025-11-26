package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class EJ09 {

	public static void main(String[] args) {
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAnuevo");
		EntityManager em=emp.createEntityManager();

		TypedQuery<Alumno> consulta=em.createQuery("Select d from Alumno d join d.cursos c", Alumno.class)
			;
		List<Alumno> lista= consulta.getResultList();
		for (Alumno alumno : lista) {
			System.out.println(alumno);
		}
		

		
		em.close();
	}
}
