package tabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CrearTabla {
	private static final String SQL_CREATE="create table if not exists Empleados(\r\n"
			+ "ID int primary key auto_increment,\r\n"
			+ "NOMBRE Varchar(100) Not null,\r\n"
			+ "Salario Decimal(10,2) Not null,\r\n"
			+ "FECHA DATETIME not null default Current_Timestamp\r\n"
			+ ")";
	
	public static void main(String[] args) {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_CREATE);
				){
			sentencia.execute();
			
		} catch (SQLException e) {
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
