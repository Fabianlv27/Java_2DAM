package tabla;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update2 {
private static final String SQL_UPDATE="UPDATE EMPLEADOS SET Salario=Salario * ? ";
	
	
	public static void main(String[] args) {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_UPDATE);
				){
			sentencia.setDouble(1, 1.10);
		
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
