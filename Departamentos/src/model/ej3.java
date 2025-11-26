package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ej3 {
	
	public static void main(String[] args) {
			EntityManagerFactory emp=Persistence.createEntityManagerFactory("JPAscott");
	EntityManager em=emp.createEntityManager();
	EntityTransaction transaccion=em.getTransaction();
	transaccion.begin();
	TypedQuery<emp> consulta=em.createQuery("Select d from emp d where d.DEPTNO=:vdep", emp.class)
		;
	consulta.setParameter("vdep",10 );
	List<emp> lista= consulta.getResultList();
	for (emp e : lista) {
		System.out.println(e);
		e.setSAL((float) (e.getSAL()*1.20) );
	}
	
	transaccion.commit();
	
	em.close();
	};

	

}
