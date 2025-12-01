package Premier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Premier01 {
	
		private static final String SQL_CREATE="create table if not exists Empleados(\r\n"
				+ "ID int primary key auto_increment,\r\n"
				+ "NOMBRE Varchar(100) Not null,\r\n"
				+ "Salario Decimal(10,2) Not null,\r\n"
				+ "FECHA DATETIME not null default Current_Timestamp\r\n"
				+ ")";
		
		static ArrayList<String[]> jugadores_data;
		static ArrayList<String> clubs=new ArrayList<String>();

		
	public static ArrayList<String[]> Obtener_Datos_Fichero(){
		String linea;
		ArrayList<String[]> lista=new ArrayList<String[]>();
		String lectura="jugadores.csv";
		
		try(BufferedReader flectura = new BufferedReader(new FileReader(lectura))){
			
			linea=flectura.readLine();
			while(linea!=null) {
			
				String[] datos=linea.split(",");
				System.out.println(datos[0].equals("full_name"));
				
				if(datos[0].equals("full_name")) {
					linea=flectura.readLine();
					continue;
				};
				String[] datos_necesarios=new String[6];
				
				int cont=0;
				for (int i = 0; i < 8; i++) {
					if(i!=2 && i!=6) {
						System.out.println("insertando "+ datos[i]);
						datos_necesarios[cont]=datos[i];
						cont++;
					}
					
				}
				lista.add(datos_necesarios);
				linea=flectura.readLine();
			}
			
			return lista;
		}catch(IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void Obtener_clubs() {
		for (String[] data : jugadores_data) {
		if (!clubs.contains(data[5])) {
			clubs.add(data[5]);
		}
		
	}
	}
	
	public static void Insertar_clubs() {
		final String SQL_INSERT_CLUB="insert into club(id,name) values(?,?) ";
		
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Premier","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_INSERT_CLUB);
			){
			
			for (int i = 0; i < clubs.size(); i++) {
				sentencia.setString(1,String.valueOf(i) );
				sentencia.setString(2, clubs.get(i));
				sentencia.executeUpdate();
			}
			

			
		} catch (SQLException e) {
			
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Insertar_Jugadores() {
		final String SQL_INSERT_Jugador="insert into jugador(id,full_name,age,birthday_GMT,league,season,id_club) values(?,?,?,?,?,?,?) ;";
		
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Premier","root","root");
				PreparedStatement sentencia=conn.prepareStatement(SQL_INSERT_Jugador);
			){
			
			for (int i = 0; i < jugadores_data.size(); i++) {
				
				System.out.println("insertando a :"+ jugadores_data.get(i)[0]);
				
				sentencia.setString(1,String.valueOf(i) );
				sentencia.setString(2,jugadores_data.get(i)[0] );
				sentencia.setInt(3,Integer.valueOf(jugadores_data.get(i)[1]) );
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
				Date date=sdf.parse(jugadores_data.get(i)[2]);
				Timestamp cumple=new Timestamp(date.getTime());
				sentencia.setTimestamp(4, cumple);
				sentencia.setString(5,jugadores_data.get(i)[3] );
				sentencia.setString(6,jugadores_data.get(i)[4] );
				sentencia.setString(7, String.valueOf(clubs.indexOf(jugadores_data.get(i)[5])));
				sentencia.executeUpdate();
			}
			

			
		} catch (SQLException e) {
			
		System.out.format("%s %s",e.getMessage(),e.getSQLState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		
	jugadores_data=Obtener_Datos_Fichero();
	Obtener_clubs();
	//Insertar_clubs();
	Insertar_Jugadores();
	}
}
