package ejercicio21;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {
	private boolean entregaRapida;

	public EnvioInternacional(String origen, String destino, double peso, LocalDate fecha, boolean entregaRapida) {
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
		double monto = 5000;
		if (this.getPeso() <= 1) monto += 10* this.getPeso();
		else monto = 12 * this.getPeso();
		if (this.isEntregaRapida()) monto += 800;
		return monto;
	}
	
	
}
