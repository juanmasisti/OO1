package ejercicio7;

public class Circulo implements Figura{
	private double radio;
	
	public Circulo(double radio){
		this.radio = radio;
	}
	
	public Circulo() {
		
	}

	//GETTER Y SETTER RADIO
		
		public double getRadio() {
			return this.radio;
		}

		public void setRadio(double radio) {
			this.radio = radio;
		}
		
	//GETTER Y SETTER DIAMETRO
		
		public double getDiametro() {
			return this.radio * 2;
		}

		//public void setDiametro(double diametro) {
			//this.diametro = diametro;
		//}

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

