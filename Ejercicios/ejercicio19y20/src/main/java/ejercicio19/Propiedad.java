package ejercicio19;
import java.util.ArrayList;
import java.util.List;

import ejercicio16.DateLapse;

public class Propiedad {
	private String direccion ;
	private String nombreD ;
	private double precioPorNoche;
	private List<Reserva> reservas;
	private PoliticaCancelacion politicaC;
	
	public Propiedad(String direccion, String nombreD, double precioPorNoche, PoliticaCancelacion politicaC) {
		this.direccion = direccion;
		this.nombreD = nombreD;
		this.precioPorNoche = precioPorNoche;
		this.reservas = new ArrayList<>();
		this.politicaC = politicaC;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getNombreD() {
		return nombreD;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	} 
	
	public PoliticaCancelacion getPoliticaC() {
		return politicaC;
	}
	public void setPoliticaCancelacion(PoliticaCancelacion politica) {
		this.politicaC = politica;
	}
	public boolean estaDisponible(DateLapse periodo) {
		return reservas.stream().noneMatch(r -> r.superponeConPeriodo(periodo));
	}
	
	public double calcularIngresos(DateLapse periodo) {
		return reservas.stream()
				.filter(r -> r.getPeriodo().overlaps(periodo))
				.mapToDouble(r -> r.calcularPrecio(precioPorNoche))
				.sum();
	}
	
	public void agregarReserva(Reserva r) {
		this.reservas.add(r);
	}
	public void eliminarReserva(Reserva r) {
		this.reservas.remove(r);
	}
}
