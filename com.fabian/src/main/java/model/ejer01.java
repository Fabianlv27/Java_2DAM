package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ejer01 {

	public static void main(String[] args) {
		
		Alumno pedro=new Alumno("3","pedro","gomez",30);
		Alumno maria=new Alumno("4","maria","perez",22);
		Curso cursoJava = new Curso("JAVA3", 300, "Introduccion a Java");
		Curso cursoNet  = new Curso("NET3", 250, "Introduccion a .NET");
		Curso cursoPhp  = new Curso("PHP3", 200, "Introduccion a PHP");
		
		pedro.addCurso(cursoPhp);
		
		
		EntityManagerFactory emp=Persistence.createEntityManagerFactory("jpa_m_n");
		EntityManager em=emp.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(pedro);
		em.persist(maria);
		em.persist(cursoJava);
		em.persist(cursoNet);
		em.persist(cursoPhp);
		em.getTransaction().commit();
		em.close();
	}

}
