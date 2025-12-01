package Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ej01 {
	    static final String URL = "jdbc:mysql://localhost:3306/Premier";
	     static final String USER = "root";
	     static final String PASSWORD = "root";
	    static Connection conn;
	    
	public static void main(String[] args) {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_CREATE);
				){
			
			
		}

	}
}
