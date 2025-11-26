package Ficheros;

import java.io.File;

public class permisos {
	 public static void main(String[] args) {
		File fich=new File(args[0]);
		if(fich.exists()&&fich.isDirectory()) {
		for(File f : fich.listFiles()) {
			if (f.isFile()) {
				System.out.println(f.getName()+ " R: "+ (f.canRead()?"✅":"⚠️")+" W: "+
						(f.canWrite()?"✅":"⚠️")+" X: "+(f.canExecute()?"✅":"⚠️"));

			}
		}
				
			}
		
	 }
}
