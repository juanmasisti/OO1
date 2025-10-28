package ejercicio14;

public class Cilindro extends Pieza{

    private double radio;
    private double altura;

	public Cilindro(String material, String color,double radio, double altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}

	@Override
	public double calcularVolumen() {
		return Math.PI * Math.pow(radio,2) * altura;
	}

	@Override
	public double calcularSuperficie() {
        return 2 * Math.PI * radio * altura + 2 * Math.PI * Math.pow(radio, 2);
	}

}
