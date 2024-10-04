package ar.edu.unlp.objetos.ejercicio2;

public class Producto {
	private double peso;
	private double pesoPorKilo;
	private String descripcion;
	
	public Producto(double peso, double pesoPorKilo, String descripcion) {
		this.peso = peso;
		this.pesoPorKilo = pesoPorKilo;
		this.descripcion = descripcion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPesoPorKilo() {
		return pesoPorKilo;
	}

	public void setPesoPorKilo(double pesoPorKilo) {
		this.pesoPorKilo = pesoPorKilo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
