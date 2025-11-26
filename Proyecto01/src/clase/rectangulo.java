package clase;

public class rectangulo extends FiguraGeometrica {

	private double dato2;
	
	
	public rectangulo(double dato1,double dato2) {
		super(dato1);
		this.dato2=dato2;
	}

	
	
	public double getDato2() {
		return dato2;
	}



	public void setDato2(double dato2) {
		this.dato2 = dato2;
	}



	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		
		return 2*(dato1+dato2);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return dato1*dato2;
	}



	@Override
	public String toString() {
		return "\nrectangulo [lado mayor ->"+dato1+ ", lado menor ->" + dato2 + "]";
	}
	
	

}
