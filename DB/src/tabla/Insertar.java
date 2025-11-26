package tabla;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;



public class Insertar {
	private static final String SQL_INSERTAR="insert into empleados(Nombre,salario,fecha) values(?,?,?)";
	
	
	public static void main(String[] args) {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_INSERTAR);
				){
			sentencia.setString(1, "Fabian");
			sentencia.setBigDecimal(2, new BigDecimal(1250.55));
			sentencia.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
			int row =sentencia.executeUpdate();
			System.out.println("filas insertadas: "+ row);
			System.out.println("Datos insertados correctamente :)");
		} catch (SQLException e) {
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
