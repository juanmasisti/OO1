package ejercicio21;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nombre;
	private String direccion;
	private List<Envio> envios;
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.envios = new ArrayList<>();
	}

	public void agregarEnvio(Envio e) {
		this.envios.add(e);
	}
	
	public double montoTotal( LocalDate inicio, LocalDate fin) {
		return this.envios.stream()
				//cuya fecha no sea antes de la inicial y no sea después de la final
				.filter(e -> !e.getFecha().isBefore(inicio) && !e.getFecha().isAfter(fin))
				.mapToDouble(Envio::calcularCosto)
				.sum() * (1 - this.descuento());
			
	}
	public abstract double descuento();
	
	public String getNombre() {
		return this.nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
