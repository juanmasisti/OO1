package ejercicio21;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio{
	private double distancia;
	
	public EnvioInterurbano (String origen, String destino, double peso, LocalDate fecha, double distancia) {
		super(origen,destino,peso,fecha);
		this.distancia = distancia;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	
	public double calcularCosto() {
		double monto;
		if (this.getDistancia() < 100) monto = 20;
		else if (this.getDistancia() >= 100 && this.getDistancia() <= 500) monto = 25;
		else monto = 30;
		return monto * this.getPeso();
	}

}
