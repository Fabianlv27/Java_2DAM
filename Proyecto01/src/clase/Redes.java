package clase;

public class Redes {
	
	public static int bin_a_dec(String binario) {
		int c=0,numero=0;
		for(int i=binario.length()-1;i>=0;i--) {
			numero +=Integer.valueOf(binario.substring(i,i+1))*Math.pow(2,c++);
		}
		return numero;
	}
	
	public static String Convertir_a_binario(int n) {
		String cadena="";
		int resto;
		
		while(n>0) {
			resto=n%2;
			n=n/2;
			cadena =String.valueOf(resto)+cadena;
		}
		return cadena;
		
	}
	public static String dec_binario(int n) {
	String cadena=Convertir_a_binario(n);
	return "0".repeat(8-cadena.length())+cadena;
		
	}
	
	public static void main(String[] args) {
		System.out.println(bin_a_dec("111"));
		String ip="192.168.1.10";
		String mascara="255.255.255.0";
		String[] matrizip=ip.split("\\.");
		String[] matrizmascara=mascara.split("\\.");
		System.out.println(matrizip[2]);
		String cadenaip="",cadenamascara="";
	
		for(String item : matrizip) {
			System.out.println(item);
			cadenaip+=dec_binario(Integer.valueOf(item));
		}
		for(String item : matrizmascara)cadenamascara+=dec_binario(Integer.valueOf(item));
		
		System.out.println(cadenaip);
		System.out.println(cadenamascara);
		
		int n=cadenamascara.indexOf("0");
		System.out.println(n);
		String red =cadenaip.substring(0,24);
		
		String ipred=red+"0".repeat(32-red.length());
		String ipBroadcast=red+"1".repeat(32-red.length());
		
		String dipred="",dipBroadcast="";
		
	}
	
}

