package parcial2024_1erFecha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoPresencial extends Evento{
	private List<Sede> sedes;
	
	public EventoPresencial(String nombre, LocalDate fecha, String tema, double precioInscripcion, double precioRemera) {
		super(nombre,fecha,tema,precioInscripcion,precioRemera);
		this.sedes = new ArrayList<>();
	}
	
	public double calcularPrecioAsistencia(LocalDate fechaConsulta) {
		double totalSedes = this.sedes.stream()
				.mapToDouble(s -> s.getPrecioPorDia() * s.getCantDias())
				.sum();
		double insc = this.getPrecioInscripcion();
        if (this.getFecha().equals(fechaConsulta)) insc *= 1.2; // recargo 20%
        
		double total = insc + this.getPrecioRemera() + totalSedes;

        return total;
	}
	
	public void agregarSede(Sede s) {
		this.sedes.add(s);
	}
}
