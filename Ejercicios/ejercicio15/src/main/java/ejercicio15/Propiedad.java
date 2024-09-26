package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioPorNoche;
	private String direccion;
	private Usuario propietario;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion, double precioPorNoche, String direccion, Usuario propietario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioPorNoche = precioPorNoche;
		this.direccion = direccion;
		this.propietario = propietario;
		this.reservas = new ArrayList<Reserva>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}
	
	public boolean disponibilidad (DateLapse periodo) {
		return this.reservas.stream().noneMatch(reserva -> reserva.overlaps(periodo));
	}
	
	public void agregarReserva (Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void eliminarReserva (Reserva reserva) {
		this.reservas.remove(reserva);
	}
	public double calcularIngresoPropiedad(DateLapse periodo) {
		return this.reservas.stream().filter(reserva -> reserva.overlaps(periodo)).mapToDouble(reserva -> reserva.calcularReserva()).sum();
		
	}
	
	public double calcularPrecio (int dias) {
		return dias * this.precioPorNoche;
	}
}
