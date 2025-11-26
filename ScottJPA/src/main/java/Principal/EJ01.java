package Principal;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.type.LocalDateTimeType;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import model.Dept;
import model.Emp;
import Principal.menu;

public class EJ01 {

	public static Scanner sc = new Scanner(System.in);
	static EntityManager em ;
	
	public static Emp preguntarDatosEmpleado(List<Dept> lista, Integer maxid) {
		String name;
		String job;
		Integer MGR;
		int dpt;
		float sal;
		Float Comm;
		Date hiredate;
sc.nextLine();
		System.out.println("Dame el nombre:");
		name = sc.nextLine();
		
		System.out.println("Dame el Trabajo");
		job = sc.nextLine();
	
		System.out.println("Elige el numero de departamento:");
		for (Dept d : lista) {
			System.out.println(d.getDeptno() + "---> " + d.getDname());
		}
		dpt = sc.nextInt();
		System.out.println("Dame el numero del empleado que es jefe (Escribe 0 si no tiene): ");
		MGR = sc.nextInt();
		if (MGR == 0) {
			MGR = null;
		}
		System.out.println("Dame le salario: ");
		sal = sc.nextFloat();
		System.out.println("Dame la comision (Escribe 0 si no tiene):");
		Comm = sc.nextFloat();
		if (Comm == 0) {
			Comm = null;
		}
		hiredate = new Date();
		for (Dept dept : lista) {
			System.out.println(dept.getDeptno()+"_" +dpt);
			if (dept.getDeptno() == dpt) {
				return new Emp((maxid + 1), Comm, name, hiredate, job, MGR, sal, dept);
			}
		}
		return null;

		// (int empno, Float comm, String ename, Date hiredate, String job, Integer mgr,
		// float sal, Dept dept)
	}
	
	public static List<Dept> GetDept() {
		TypedQuery<Dept> consulta = (TypedQuery<Dept>) em.createNamedQuery("Dept.findAll");
		List<Dept> lista = consulta.getResultList();
		return lista;
	}
	
	public static void ListarDept() {
		List<Dept> l=GetDept();
		for (Dept dept : l) {
			System.out.println(l);
		}
	}

	public static void CreateEmp() {
		
		List<Dept> lista=GetDept();
		TypedQuery<Integer> maxIdquery = em.createQuery("Select MAX(e.empno) from Emp e", Integer.class);
		Integer maxId = maxIdquery.getSingleResult();
		System.out.println(maxId);
		Emp newEmpleado = preguntarDatosEmpleado(lista, maxId);
	
			em.persist(newEmpleado);
			System.out.println("Empleado Creado con exito!!");
		
		

	}
	
	public static void ShowMenu() {
	    String[] ops = {
	        "1.- Listar departamentos",
	        "2.- Listar empleados",
	        "3.- Dar de alta",
	        "4.- Dar de baja",
	        "5.- Modificar datos",
	        "6.- Salir"
	    };

	    int op = 0;
	    do {
	        op = menu.menu(sc, ops);

	        switch (op) {
	            case 1:
	                ListarDept();
	                break;
	            case 2:
	                // Listar empleados
	                break;
	            case 3:
	                CreateEmp();
	                break;
	            case 4:
	                // Dar de baja
	                break;
	            case 5:
	                // Modificar datos
	                break;
	            case 6:
	                System.out.println("Saliendo del programa...");
	                break;
	            default:
	                System.out.println("Opción inválida. Intenta de nuevo.");
	        }

	        if (op != 6) {
	            System.out.println("Presiona ENTER para continuar...");
	            sc.nextLine(); // Limpia el buffer
	            sc.nextLine(); // Espera ENTER
	        }

	    } while (op != 6);
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emp = Persistence.createEntityManagerFactory("ScottJPA");
		em = emp.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		try {
			transaccion.begin();
			ShowMenu();
			transaccion.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		em.close();
	}

}
