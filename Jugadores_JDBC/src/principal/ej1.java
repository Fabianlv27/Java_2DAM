package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

import clase.Equipo;



public class ej1 {

	static TreeMap<Integer,Equipo> clasificacion=new TreeMap<>();
	static int jornada=7;
	static ArrayList<Equipo> lequipos=new ArrayList<Equipo>();
	
	public static void main(String[] args) throws SQLException {
		
		llenar_equipos();
		cargar_partidos();
		
		for (Integer e:clasificacion.keySet()) {
			lequipos.add(clasificacion.get(e));
			
		}
		lequipos.sort(new ordenar());
		
		for (Equipo equipo:lequipos) System.out.println(equipo);
		
		Llenar_fichero();
		
	}
	
	public static void llenar_equipos() throws SQLException {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/laliga","root","root");
				PreparedStatement sentencia=conn.prepareStatement("select * from equipos");
				
				){
			ResultSet r =sentencia.executeQuery();
			while(r.next()) {
				clasificacion.put(
						r.getInt("IDEQUIPO"),
						new Equipo(r.getNString("NOMBRE"))
						);
				
			}
		}
	}
	
	public static void cargar_partidos() throws SQLException {
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/laliga","root","root");
				PreparedStatement sentencia=conn.prepareStatement("select * from partidos where IDJORNADA <= "+jornada);
				
				){
			ResultSet r =sentencia.executeQuery();
			int diferencia;
			Equipo eq;
			
			while(r.next()) {
				r.getInt("IDLOCAL");
				r.getInt("IDVISITANTE");
				
				diferencia= r.getInt("GOL_LOCAL")-r.getInt("GOL_VISITANTE");
				if (diferencia >0) {
					eq=clasificacion.get(r.getInt("IDLOCAL"));
					eq.setPuntos(eq.getPuntos()+3);
					clasificacion.put(r.getInt("IDLOCAL"),eq );
					
				}else if(diferencia<0) {
					eq=clasificacion.get(r.getInt("IDVISITANTE"));
					eq.setPuntos(eq.getPuntos()+3);
					clasificacion.put(r.getInt("IDVISITANTE"),eq );
				}
				else {
					eq=clasificacion.get(r.getInt("IDVISITANTE"));
					eq.setPuntos(eq.getPuntos()+1);
					clasificacion.put(r.getInt("IDVISITANTE"),eq );
					
					eq=clasificacion.get(r.getInt("IDLOCAL"));
					eq.setPuntos(eq.getPuntos()+1);
					clasificacion.put(r.getInt("IDLOCAL"),eq );
				}
			}
		}
	}
	
public static void Llenar_fichero() {
	
	 String escritura="Jornada"+jornada+".dat";
	 
	 try(BufferedWriter fescritura = new BufferedWriter(new FileWriter(escritura))){
		 fescritura.write("Clasificacion jornada "+ jornada +"\n\n");
		 int c=0;
		 for (Equipo e : lequipos) {
			fescritura.write(String.format("%2d %20s %3d",++c,e.getNombre(),e.getPuntos() )+"\n");
		}
	 
	 }
	 catch(IOException e) {
	 System.out.println(e.getMessage());
	 }
	 

}
	
	
	
}
 class ordenar implements Comparator<Equipo>{
		@Override
		public int compare(Equipo o1,Equipo o2) {
			return o1.getPuntos()-o2.getPuntos();
			
		}
		
	}