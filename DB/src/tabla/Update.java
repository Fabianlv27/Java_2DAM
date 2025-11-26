package tabla;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Update {
private static final String SQL_UPDATE="UPDATE EMPLEADOS SET Salario=? Where NOMBRE=?";
	
	
	public static void main(String[] args) {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_UPDATE);
				){
			sentencia.setBigDecimal(1, new BigDecimal(5250.55));
			sentencia.setString(2, "Fabian");
			
		
			int row =sentencia.executeUpdate();
			System.out.println("filas Actualizadas: "+ row);
			System.out.println("Datos actual correctamente :)");
		} catch (SQLException e) {
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
