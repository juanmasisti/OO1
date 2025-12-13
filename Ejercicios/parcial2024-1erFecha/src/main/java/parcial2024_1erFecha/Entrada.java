package parcial2024_1erFecha;

import java.time.LocalDate;
import java.time.Period;

public class Entrada {
	private boolean tieneSeguro;
	private LocalDate fechaCompra;
	private Evento evento;
	
	public Entrada(boolean tieneSeguro, LocalDate fechaCompra, Evento evento) {
		this.tieneSeguro = tieneSeguro;
		this.fechaCompra = fechaCompra;
		this.evento = evento;
	}

	public Evento getEvento() {
		return this.evento;
	}
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	
	public double obtenerValorEntrada() {
		double valor = this.evento.calcularPrecioAsistencia(this.getFechaCompra());
		if (this.tieneSeguro) valor += 500;
		return valor;
	}
	
	public double calcularMontoARecuperar() {
		 int dif = Period.between(fechaCompra, this.evento.getFecha()).getDays();
		 double monto = this.evento.calcularPrecioAsistencia(fechaCompra) * 0.5;
		 if (dif >= 30 && this.tieneSeguro) return monto + evento.calcularPrecioAsistencia(fechaCompra) * 0.15;
		 else if (dif >= 30) return monto;
		 else return 0;
	}
}
