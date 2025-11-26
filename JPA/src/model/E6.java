package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class E6 {
public static void main(String[] args) {
	EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAnuevo");
	EntityManager em=emp.createEntityManager();
	EntityTransaction transaccion=em.getTransaction();
	transaccion.begin();
	TypedQuery<Alumno> consulta=em.createQuery("Select d from Alumno d where d.edad>:vedad", Alumno.class)
		;
	consulta.setParameter("vedad",20 );
	List<Alumno> lista= consulta.getResultList();
	for (Alumno alumno : lista) {
		System.out.println(alumno);
	}
	
	transaccion.commit();
	
	em.close();
}

}
