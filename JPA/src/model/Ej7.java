package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Ej7 {
	public static void main(String[] args) {
		
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAnuevo");
		EntityManager em=emp.createEntityManager();
		EntityTransaction transaccion=em.getTransaction();
		

		Alumno PedroSanchez=new Alumno("54454","pedro","gomez",30);
		Alumno MariaDB=new Alumno("3666","maria","perez",28);
		Cursos cursoJava2=new Cursos("JAVA22","Introduccion Java",20,300,PedroSanchez);
		Cursos cursoNET2=new Cursos("NET22","Introduccion NET",20,300,PedroSanchez);
		Cursos cursoPHP2=new Cursos("PHP22","Introduccion PHP",15,250,MariaDB);
		
		PedroSanchez.add(cursoJava2);
		PedroSanchez.add(cursoNET2);
		PedroSanchez.add(cursoPHP2);
		
		transaccion.begin();
		em.persist(PedroSanchez);
		em.persist(MariaDB);
		
		transaccion.commit();
		
		em.close();
		
	}


}
