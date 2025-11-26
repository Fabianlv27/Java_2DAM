package tabla;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Batch {
		private static final String SQL_DROP="Drop Table if  exists Empleados";
	private static final String SQL_CREATE="create table if not exists Empleados(\r\n"
			+ "ID int primary key auto_increment,\r\n"
			+ "NOMBRE Varchar(100) Not null,\r\n"
			+ "Salario Decimal(10,2) Not null,\r\n"
			+ "FECHA DATETIME not null default Current_Timestamp\r\n"
			+ ")";

private static final String SQL_DELETE="Delete From EMPLEADOS Where salario < ?";
private static final String SQL_INSERTAR="insert into empleados(Nombre,salario,fecha) values(?,?,?)";
private static final String SQL_UPDATE="UPDATE EMPLEADOS SET Salario=? Where NOMBRE=?";

	public static void main(String[] args) {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
				PreparedStatement pd=conn.prepareStatement(SQL_DROP);
				PreparedStatement pc=conn.prepareStatement(SQL_CREATE);
				PreparedStatement pi=conn.prepareStatement(SQL_INSERTAR);
				PreparedStatement pu=conn.prepareStatement(SQL_UPDATE);
				){
			conn.setAutoCommit(false);
			
			pd.execute();
			pc.execute();
			
			pi.setString(1, "Carlos");
			pi.setBigDecimal(2, new BigDecimal(4254.2));
			pi.setTimestamp(3, Timestamp.valueOf(LocalDateTime.of(2025, 10, 10, 12, 23)));
			pi.addBatch();

			pi.setString(1, "Lucía");
			pi.setBigDecimal(2, new BigDecimal(3820.5));
			pi.setTimestamp(3, Timestamp.valueOf(LocalDateTime.of(2024, 5, 15, 9, 0)));
			pi.addBatch();

			pi.setString(1, "Andrés");
			pi.setBigDecimal(2, new BigDecimal(5100.0));
			pi.setTimestamp(3, Timestamp.valueOf(LocalDateTime.of(2023, 3, 20, 14, 45)));
			pi.addBatch();

			pi.setString(1, "María");
			pi.setBigDecimal(2, new BigDecimal(4700.75));
			pi.setTimestamp(3, Timestamp.valueOf(LocalDateTime.of(2022, 12, 1, 8, 30)));
			pi.addBatch();

			pi.setString(1, "Juan Ignacio");
			pi.setBigDecimal(2, new BigDecimal(4999.99));
			pi.setTimestamp(3, Timestamp.valueOf(LocalDateTime.of(2025, 1, 5, 16, 10)));
			pi.addBatch();
			
			pu.setBigDecimal(1, new BigDecimal(8900.55));
			pu.setString(2, "Carlos");
			
			pu.addBatch();
			
			
			int[] rows=pi.executeBatch();
			int[] rows2=pu.executeBatch();
			
			System.out.println(Arrays.toString(rows) );
			System.out.println(Arrays.toString(rows2) );
			
			conn.commit();
		
			System.out.println("Datos Borrados correctamente :)");
		} catch (SQLException e) {
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
