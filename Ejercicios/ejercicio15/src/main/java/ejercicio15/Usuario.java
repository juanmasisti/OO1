package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
private String nombre;
private String direccion;
private String dni;
private List<Reserva> reservas;
private List<Propiedad> propiedades;

	public Usuario(String nombre, String direccion, String dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.reservas = new ArrayList<Reserva>();
		this.propiedades = new ArrayList<Propiedad>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void agregarReserva (Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void eliminarReserva (Reserva reserva){
		this.reservas.remove(reserva);
	}
	
	public void agregarPropiedad (Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public void eliminarPropiedad (Propiedad propiedad) {
		this.propiedades.remove(propiedad);
	}

	public double calcularIngresoPropietario (DateLapse periodo) {
		return this.propiedades.stream().mapToDouble(propiedad -> propiedad.calcularIngresoPropiedad(periodo)).sum();
	}
	

}
