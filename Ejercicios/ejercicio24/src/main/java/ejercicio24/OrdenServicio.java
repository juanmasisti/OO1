package ejercicio24;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenServicio extends Orden {
	private String descripcion;
	private int horas;
	private List<Tecnico> tecnicos;
	
	public OrdenServicio(LocalDate fecha, Usuario usuario, String domicilio, String descripcion, int horas) {
		super(fecha, usuario, domicilio);
		this.descripcion = descripcion;
		this.horas = horas;
		this.tecnicos = new ArrayList<>();
		
	}
	
	public void agregarTecnico(Tecnico t) {
		this.tecnicos.add(t);
	}
	
	public double calcularCosto() {
		double costoProductos = this.getProductos().stream()
				.mapToDouble(p -> p.getCosto())
				.sum();
		
		double costoTecnico = this.tecnicos.stream()
		.mapToDouble(t -> t.getValorHora())
		.sum() * horas;

		double total = costoTecnico + costoProductos;
		if (horas > 10)
			total *= 0.9;
		return total;
	}
}
