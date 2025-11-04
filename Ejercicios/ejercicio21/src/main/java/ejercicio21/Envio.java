package ejercicio21;

import java.time.LocalDate;

public abstract class Envio {
	private String origen;
	private String destino;
	private double peso;
	private LocalDate fecha;
	
	public Envio(String origen, String destino, double peso, LocalDate fecha) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
		this.fecha = fecha;
	}
	
	public abstract double calcularCosto();

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
