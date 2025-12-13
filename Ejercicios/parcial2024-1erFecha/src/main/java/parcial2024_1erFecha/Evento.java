package parcial2024_1erFecha;

import java.time.LocalDate;

public abstract class Evento {
	private String nombre;
	private LocalDate fecha;
	private String tema;
	private double precioInscripcion;
	private double precioRemera;
	
	public Evento(String nombre, LocalDate fecha, String tema, double precioInscripcion, double precioRemera) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.tema = tema;
		this.precioInscripcion = precioInscripcion;
		this.precioRemera = precioRemera;
	}
	
	public abstract double calcularPrecioAsistencia(LocalDate fechaConsulta);

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getTema() {
		return tema;
	}

	public double getPrecioInscripcion() {
		return precioInscripcion;
	}

	public double getPrecioRemera() {
		return precioRemera;
	}
	
	
}
