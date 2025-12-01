package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

public class ejer02 {
public static void main(String[] args) {
	EntityManagerFactory emp=Persistence.createEntityManagerFactory("jpa_m_n");
	EntityManager em=emp.createEntityManager();
	EntityTransaction transaccion=em.getTransaction();
	transaccion.begin();
	
	Alumno p=em.find(Alumno.class, "1");
	Alumno m=em.find(Alumno.class, "2");
	Curso c=em.find(Curso.class, "JAVA2");
	c.remove(p);
	c.remove(m);
	transaccion.commit();
	em.close();
	//clientes id(auto) nombre productos id(auto) nombre 
	
}

}
