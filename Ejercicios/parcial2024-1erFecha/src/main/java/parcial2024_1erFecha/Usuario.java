package parcial2024_1erFecha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private List<Entrada> entradas;
	
	public Usuario(String nombre, LocalDate fecha) {
		this.nombre = nombre;
		this.entradas = new ArrayList<Entrada>();
	}
	
	public double consultarPrecioAsistencia(Evento evento, LocalDate fechaConsulta) {
	    return evento.calcularPrecioAsistencia(fechaConsulta);
	}

	
	public Entrada comprarEntrada(Evento e, boolean tieneSeguro) {
		Entrada entrada = new Entrada(tieneSeguro, LocalDate.now(), e);
		this.entradas.add(entrada);
		return entrada;
		
	}
	
	public double calcularMontoTotalEntradas(LocalDate inicio, LocalDate fin) {
		return 
		this.entradas.stream()
		//filtramos entradas cuya fecha compra no sea antes de la fecha inicio y no sea despues de la fecha fin 
		//(nos quedamos con las compradas entre ese intervalo)
		.filter(e -> !e.getFechaCompra().isBefore(inicio) && !e.getFechaCompra().isAfter(fin))
		.mapToDouble(e -> e.obtenerValorEntrada())
		.sum();
	}
	
	public Entrada retornarEntradaSiguienteEvento() {
	    LocalDate hoy = LocalDate.now();
	    Entrada siguiente = null;

	    for (Entrada e : this.entradas) {
	        LocalDate fechaEvento = e.getEvento().getFecha();

	        if (fechaEvento.isAfter(hoy)) {
	            // Si aún no hay siguiente o encontramos uno más cercano
	            if (siguiente == null || 
	                fechaEvento.isBefore(siguiente.getEvento().getFecha())) {
	                siguiente = e;
	            }
	        }
	    }

	    return siguiente; // puede ser null si no hay ninguno posterior
	}

	
}
