package parcial.parcial1;

import java.time.LocalDate;
import java.util.List;

public class OrdenCompra extends Orden {

	public OrdenCompra(String patente, LocalDate fechaActual, List<Repuesto> respuestos) {
		super(patente, fechaActual, respuestos);
	}

	public double calcularMonto() {
		return this.getRepuestos().stream().mapToDouble(repuesto -> repuesto.getCosto()).sum();
	}
	public int calcularGanancia() {
		if (this.getRepuestos().stream().anyMatch(repuesto -> repuesto.masDe5())) {
			return 8;
		}
		return 15;
	}

}
