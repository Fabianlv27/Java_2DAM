package Gestisimal;

import java.util.ArrayList;

public  class  Almacen {
	private ArrayList<Articulo> Almacenador;

	public ArrayList<Articulo> getAlmacenador() {
		return Almacenador;
	}

	public void setAlmacenador(ArrayList<Articulo> almacenador) {
		Almacenador = almacenador;
	}

	public Almacen() {
		Almacenador=new ArrayList<>();
	}
	
	public void Alta(Articulo a) {
		Almacenador.add(a);
	}
	public void Baja(Articulo a) {
		Almacenador.remove(a);
	}
	
	
	public void Listar() {
		for(Articulo a:Almacenador) {System.out.println(a);}
	}
	
	public void manejo_mercancia(Articulo a,int cant) {
		a.setStock(a.getStock()+cant);
	}

	
	
	
	
}
