package tabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearDataBase {
	private static final String SQL_CREATE="create DataBase if not exists Cajero";
	private static final String SQL_DELETE="Drop DataBase if  exists Cajero";
	
	public static void main(String[] args) {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_DELETE);
				PreparedStatement sentencia1=conn.prepareStatement(SQL_CREATE);
				){
			sentencia.execute();
			sentencia1.execute();
			System.out.println("Database creada");
		} catch (SQLException e) {
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
