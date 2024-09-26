package parcial.parcial1;

import java.time.LocalDate;

public class Factura {
	private LocalDate fecha;
	private String patente;
	private double montoFinal;
	private double descuento;
	
	public Factura(LocalDate fecha, String patente, double montoFinal, double descuento) {
		this.fecha = fecha;
		this.patente = patente;
		this.montoFinal = montoFinal;
		this.descuento = descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getPatente() {
		return patente;
	}

	public double getMontoFinal() {
		return montoFinal;
	}

	public double getDescuento() {
		return descuento;
	}
	
	
}
