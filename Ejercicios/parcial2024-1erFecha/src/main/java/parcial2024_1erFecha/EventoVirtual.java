package parcial2024_1erFecha;

import java.time.LocalDate;
import java.util.ArrayList;

public class EventoVirtual extends Evento{
	private double montoFijoEnvio;
	
	public EventoVirtual(String nombre, LocalDate fecha, String tema, double precioInscripcion, double precioRemera, double montoFijoEnvio) {
		super(nombre,fecha,tema,precioInscripcion,precioRemera);
		this.montoFijoEnvio = montoFijoEnvio;
	}
	
	public double calcularPrecioAsistencia(LocalDate fechaConsulta) {
		double insc = this.getPrecioInscripcion();
        if (this.getFecha().equals(fechaConsulta)) insc *= 1.2; // recargo 20%
		double total = insc + this.getPrecioRemera() + this.montoFijoEnvio;
        return total;
 
	}
}
