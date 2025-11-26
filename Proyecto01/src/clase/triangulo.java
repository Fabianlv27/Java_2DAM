package clase;

public class triangulo extends FiguraGeometrica {
	private double altura;
	
	
	
	public triangulo(double dato1, double altura) {
		super(dato1);
		this.altura = altura;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 2*(Math.pow((dato1/2), 2)+ Math.pow(altura, 2))+dato1;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (dato1*altura)/2;
	}

	@Override
	public String toString() {
		return "\ntriangulo [ base -> "+dato1 +", altura=" + altura + "]";
	}

}
