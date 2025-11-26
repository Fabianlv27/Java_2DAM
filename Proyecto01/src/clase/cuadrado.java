package clase;

public class cuadrado extends FiguraGeometrica {
	
	
	
	public cuadrado(double dato1) {
		super(dato1);
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 4*dato1;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		
		return Math.pow(dato1, 2);
	}

	@Override
	public String toString() {
		return "\ncuadrado [lado -> "+ dato1 +" ]";
	}

	

}
