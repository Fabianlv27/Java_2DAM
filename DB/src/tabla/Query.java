package tabla;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Query {
private static final String SQL_INSERTAR="Select * From Empleados";
	
	
	public static void main(String[] args) {
		int id;
		String nombre;
		double salario;
		Timestamp fecha;
		Empleado emp=null;
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_INSERTAR);
				){
			ResultSet resultados=sentencia.executeQuery();
			while (resultados.next()) {
				id=resultados.getInt(1);
				nombre=resultados.getString(2);
				salario=resultados.getDouble(3);
				fecha=resultados.getTimestamp(4);
				emp=new Empleado(id, nombre, salario,fecha.toLocalDateTime());
				System.out.println(emp);
			}

			System.out.println("Datos leidos correctamente :)");
		} catch (SQLException e) {
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
