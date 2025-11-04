package ejercicio21;

import java.time.LocalDate;

public class EnvioLocal extends Envio{
	private boolean entregaRapida;

	public EnvioLocal(String origen, String destino, double peso, LocalDate fecha, boolean entregaRapida) {
		super(origen, destino, peso, fecha);
		this.entregaRapida = entregaRapida;
	}

	public boolean isEntregaRapida() {
		return entregaRapida;
	}

	public void setEntregaRapida(boolean entregaRapida) {
		this.entregaRapida = entregaRapida;
	}
	
	public double calcularCosto() {
		double costo = 1000;
		if (this.isEntregaRapida()) return costo + 500;
		return costo;
	}
	

}
