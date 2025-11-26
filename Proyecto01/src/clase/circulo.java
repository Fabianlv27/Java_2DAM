package clase;

public class circulo extends FiguraGeometrica {

	
	
	public circulo(double dato1) {
		super(dato1);
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 2*Math.PI*dato1;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI*Math.pow(dato1,2);
	}

	@Override
	public String toString() {
		return "\ncirculo [radio -> "+dato1 +"]";
	}

}
