package ejercicio14;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;

	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<>();
	}

	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	public List<Pieza> getPiezas(){
		return piezas;
	}
	
	public double volumenDeMaterial(String material) {
		return piezas.stream()
				.filter(p -> p.getMaterial().equalsIgnoreCase(material))
				.mapToDouble(Pieza::calcularVolumen)
				.sum();
	}
	
	public double superficieDeColor(String color) {
		return piezas.stream()
				.filter(p -> p.getColor().equalsIgnoreCase(color))
				.mapToDouble(Pieza::calcularSuperficie)
				.sum();
	}
	
}
