package hilos;

import java.util.HashMap;

import java.util.Random;
import java.util.Set;

public class EncuestaHerencia {
//leer provincias de comunidad autonomas en un csv,por cada provincia un 
	// numero aleatorio comprendidas entre 0 y 20 años
private static final int  NUM_ZONAS=20;
	
	
	public static void main(String[] args) {
		ResultadoEncuesta3 resultados = new ResultadoEncuesta3();
		Thread [] encuestadores = new Thread[NUM_ZONAS];
		for(int i=0;i<NUM_ZONAS;i++) {
			encuestadores[i] = new EncuestadorZona2("zona_"+(i+1),resultados);
		}
		
		for(Thread encuestador: encuestadores) encuestador.start();
		
		for(Thread encuestador: encuestadores) {
			try {
				encuestador.join();
			}catch(InterruptedException ex) {}
				
			
		}
		/****************************************************************************/
		System.out.println("Encuestas por Zona");
		int total = 0, tzona;
		for(String zona: resultados.obtenerZonas()) {
			tzona = resultados.obtenNumRespuestasZona(zona);
			total += tzona;
			System.out.printf("%s: %d\n",zona,tzona);
		}
		System.out.printf("TOTAL: %d\n",total);
		/****************************************************************************/
		System.out.println("Encuestas por Zonas");
		total = 0;
		for(String respuesta: resultados.obtenerRespuesta()) {
			tzona=resultados.obtenNumRespuestas(respuesta);
			total += tzona;
			System.out.printf("%s: %d\n",respuesta != null ? respuesta : "NS/NC", tzona);
		}
		System.out.printf("TOTAL: %d\n",total);
		/****************************************************************************/
		
	}

}

/*********************************************************************************************/
class ResultadoEncuesta3{
	private final HashMap<String, Integer> totalPorRespuesta = new HashMap<String, Integer>();
	private final HashMap<String, Integer> totalPorZona = new HashMap<String, Integer>();
	
	synchronized public void anotaRespuesta(String idZona, String respuesta) {
		Integer n = this.totalPorRespuesta.get(respuesta);
		this.totalPorRespuesta.put(respuesta, n==null ? 1 : n+1);
		n = this.totalPorZona.get(idZona);
		this.totalPorZona.put(idZona, n==null ? 1 : n+1);
	}
	
	synchronized public Set<String> obtenerZonas(){
		return this.totalPorZona.keySet();
	}
	
	synchronized public Set<String> obtenerRespuesta(){
		return this.totalPorRespuesta.keySet();
	}
	
	synchronized public int obtenNumRespuestasZona(String zona) {
		return this.totalPorZona.get(zona);
	}
	synchronized public int obtenNumRespuestas(String respuesta) {
		return this.totalPorRespuesta.get(respuesta);
	}
}
/*********************************************************************************************/
class aleatorio3{
	public static int alea(int li, int ls) {
		return (int) (Math.random()*(ls-li+1)+li);
	}
}
/*********************************************************************************************/

class EncuestadorZona2 extends Thread{
	public final String idZona;
	private final ResultadoEncuesta3 resultados;
	
	public EncuestadorZona2(String idZona, ResultadoEncuesta3 resultados) {
		super();
		this.idZona = idZona;
		this.resultados = resultados;
	}

	@Override
	public void run() {
		System.out.printf(">>Encuestador para zona %s comienza.\n",this.idZona);
		int numRespuestas=aleatorio3.alea(100,200);
		for(int i=0; i<numRespuestas;i++) {
			int numRespuesta=aleatorio3.alea(0, 9);
			String respuesta = numRespuesta==0 ? null : "Respuesta_"+numRespuesta;
			this.resultados.anotaRespuesta(this.idZona, respuesta);
			
		}
		System.out.printf("Encuestador zona %s terminada.\n",this.idZona);
		
	}
	
}