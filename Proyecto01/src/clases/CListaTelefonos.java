package clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CListaTelefonos {
	private RandomAccessFile fes;
	private int nregs;
	private int tamañoReg=140;
	
	public CListaTelefonos(File fichero) throws IOException {
		if (fichero.exists()&&!fichero.isFile()) {
			throw new IOException(fichero.getName()+"no es un fichero");
		}
		fes=new RandomAccessFile(fichero, "rw");
		nregs=(int) Math.ceil((double)fichero.length()/this.tamañoReg);
	}
	
	
	
	public RandomAccessFile getFes() {
		return fes;
	}



	public void setFes(RandomAccessFile fes) {
		this.fes = fes;
	}



	public int getNregs() {
		return nregs;
	}



	public void setNregs(int nregs) {
		this.nregs = nregs;
	}



	public int getTamañoReg() {
		return tamañoReg;
	}



	public void setTamañoReg(int tamañoReg) {
		this.tamañoReg = tamañoReg;
	}


	/**
	 * @throws IOException ************************/
	
	public void cerrar() throws IOException{
		fes.close();
	}
	/**
	 * @throws IOException ************************/
	
	public int longitud() throws IOException{
		return nregs;
	}
	/**
	 * @throws IOException ************************/
	public void añadir(CPersona p) throws IOException {
		if(ponerValorEn(nregs, p)) nregs++;
	}
	/**
	 * @throws IOException ************************/
	public int Buscar(String str,int pos) throws IOException {
		CPersona p;
		if(str==null) return -1;
		if(pos<0)pos=0;
		for (int i = pos; i < nregs; i++) {
			p=valorEn(i);
			if (str.equalsIgnoreCase(p.getNombre()))return i;
		}
		return -1;
		
	}
	/**
	 * @throws IOException ************************/
	public boolean Eliminar(long tel) throws IOException {
		CPersona p;
		for (int i = 0; i < nregs; i++) {
			p=valorEn(i);
			if (tel==p.getTelefono()) {
				p.setTelefono(0);
				ponerValorEn(i, p);
				return true;
			};
		}
		return false;
		
	}
	/**
	 * @throws IOException ************************/
	
	/**
	 * @throws IOException ************************/
	
	public boolean ponerValorEn(int i,CPersona p) throws IOException {

		if(i>=0 && i<=nregs) {
			if (p.tamaño()+4>getTamañoReg()) {
				System.out.println("tamaño del registro excedido");
			}else {
		fes.seek(i*tamañoReg);
		fes.writeUTF(p.getNombre());
		fes.writeUTF(p.getDireccion());
		fes.writeLong(p.getTelefono());
		return true;
			}
			
		}else {
			System.out.println("numero de registro fuera de limites");
		}
		return false;

	}
	
	public CPersona valorEn(int i) throws IOException {
		if(i>=0 && i<=nregs) {
			fes.seek(i*tamañoReg);
			return new CPersona(fes.readUTF(),fes.readUTF(),fes.readLong());
		}else {
			System.out.println("numero de registro fuera de limites");
		}
		return null;
	}
	
}
