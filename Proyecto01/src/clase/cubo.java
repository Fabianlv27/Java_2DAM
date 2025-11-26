package clase;

public class cubo extends cuadrado {

	public cubo(double dato1) {
		super(dato1);
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return dato1*12;
	}

	public double volumen() {
		// TODO Auto-generated method stub
		return Math.pow(dato1, 3);
	}

	@Override
	public String toString() {
		return "\ncubo [lado -> "+dato1+ "]";
	}
	

}
