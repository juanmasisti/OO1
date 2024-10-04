package ejercicio5_figurasYCuerpos;

public class Circulo implements Figura{
	private double radio;
	private double diametro;

	//GETTER Y SETTER RADIO
		
		public double getRadio() {
			return this.radio;
		}

		public void setRadio(double radio) {
			this.radio = radio;
		}
		
	//GETTER Y SETTER DIAMETRO
		
		public double getDiametro() {
			return this.diametro;
		}

		public void setDiametro(double valor) {
			this.diametro = valor;
		}

	//AREA Y PERIMETRO	
		
		@Override
		public double getPerimetro() {
			return (Math.PI * this.getDiametro());
		}

		@Override
		public double getArea() {
			return (Math.PI * (Math.pow(this.getRadio(), 2)));
		}

}

