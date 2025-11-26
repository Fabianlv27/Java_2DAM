package tabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
private static final String SQL_UPDATE="Delete From EMPLEADOS Where salario < ?";
	
	
	public static void main(String[] args) {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_UPDATE);
				){
			sentencia.setDouble(1, 1500.50);
		
			int row =sentencia.executeUpdate();
			System.out.println("filas Borradas: "+ row);
			System.out.println("Datos Borrados correctamente :)");
		} catch (SQLException e) {
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
