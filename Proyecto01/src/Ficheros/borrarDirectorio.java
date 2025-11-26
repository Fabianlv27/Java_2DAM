package Ficheros;

import java.io.File;

public class borrarDirectorio {
	public static void main(String[] args) {
		String path=args[0];
		File fich =new File(path);
		
		if(fich.exists() && fich.isDirectory())
			for(File f:fich.listFiles())
				if (f.isFile() && f.getName().endsWith(".csv"))
					f.delete();
	}
}
