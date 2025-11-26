package tabla;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class InsertarArrayList {
private static final String SQL_INSERTAR="insert into empleados(Nombre,salario,fecha) values(?,?,?)";
	

	public static void llenar(ArrayList<Empleado> l) {
		l.add(new Empleado("Juan Ignacio", 500, LocalDateTime.of(2025, 10, 10, 12, 23)));
		l.add(new Empleado("María López", 750, LocalDateTime.of(2024, 5, 15, 9, 0)));
		l.add(new Empleado("Carlos Pérez", 620, LocalDateTime.of(2023, 3, 20, 14, 45)));
		l.add(new Empleado("Lucía Gómez", 800, LocalDateTime.of(2022, 12, 1, 8, 30)));
		l.add(new Empleado("Andrés Torres", 550, LocalDateTime.of(2025, 1, 5, 16, 10)));

	}
	
	public static void main(String[] args) {
		
		ArrayList<Empleado> lista=new ArrayList<Empleado>();
		int row=0;
		llenar(lista);
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_INSERTAR);
				){
			
			for (Empleado emp : lista) {
				sentencia.setString(1,emp.getNombre());
				sentencia.setDouble(2,emp.getSalario());
				sentencia.setTimestamp(3,Timestamp.valueOf(emp.getFecha()));
				 row +=sentencia.executeUpdate();
			}

			System.out.println("filas insertadas: "+ row);
			System.out.println("Datos insertados correctamente :)");
		} catch (SQLException e) {
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
