package parcial.parcial1;

import java.time.LocalDate;
import java.util.List;

public class OrdenReparacion extends Orden {
	private String descripcion;
	private List<Empleado> empleados;
	private double cantHoras;
	
	public OrdenReparacion(String patente, LocalDate fechaActual, List<Repuesto> respuestos, String descripcion, double cantHoras, List<Empleado> empleados) {
		super(patente, fechaActual, respuestos);
		this.descripcion = descripcion;
		this.cantHoras = cantHoras;
		this.empleados = empleados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public double getcantHoras() {
		return cantHoras;
	}
	
	public double calcularMonto() {
		double total = empleados.stream().mapToDouble(empleado -> empleado.getValorHora()).sum();
		double costoRepuestos = this.getRepuestos().stream().mapToDouble(repuesto -> repuesto.getCosto()).sum();
		return costoRepuestos + (total*cantHoras);
	}
	public int calcularGanancia() {
		return 10;
	}
	
	
	
}
