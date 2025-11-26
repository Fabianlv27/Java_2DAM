package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class E5 {

	public static void main(String[] args) {
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAnuevo");
		EntityManager em=emp.createEntityManager();
		EntityTransaction transaccion=em.getTransaction();
		transaccion.begin();
		TypedQuery<Alumno> consulta=
				(TypedQuery<Alumno>)em.createNamedQuery("Alumno.todos");
		List<Alumno> lista= consulta.getResultList();
		for (Alumno alumno : lista) {
			System.out.println(alumno);
			alumno.setEdad(alumno.getEdad()-3);
		}
		
		transaccion.commit();
		
		em.close();
	}

}
