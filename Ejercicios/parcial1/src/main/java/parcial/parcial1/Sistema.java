package parcial.parcial1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
private List<Empleado> empleados;
private List<Repuesto> repuestos;
private List<Orden> ordenes;

	public Sistema() {
		empleados = new ArrayList<Empleado>();
		repuestos = new ArrayList<Repuesto>();
		ordenes = new ArrayList<Orden>();
	}
	
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public List<Repuesto> getRepuestos() {
		return repuestos;
	}


	public List<Orden> getOrdenes() {
		return ordenes;
	}


	public Empleado altaEmpleado(String nombre, double valorHora) {
		Empleado empleado = new Empleado(nombre, valorHora);
		this.empleados.add(empleado);
		return empleado;
	}
	
	public Repuesto altaRepuesto(String nombre, LocalDate fechaFabricacion, double costo) {
		Repuesto repuesto = new Repuesto(nombre,fechaFabricacion,costo);
		this.repuestos.add(repuesto);
		return repuesto;
	}
	
	public OrdenCompra registrarOrdenCompra(String patente,List<Repuesto> repuestos) {
		OrdenCompra orden = new OrdenCompra(patente,LocalDate.now(),repuestos);
		this.ordenes.add(orden);
		return orden;
	}
	
	public OrdenReparacion registrarOrdenReparacion(String patente, String descripcion, List<Repuesto> repuestos, List<Empleado> empleados, double cantHoras) {
		OrdenReparacion orden = new OrdenReparacion(patente,LocalDate.now(),repuestos,descripcion,cantHoras,empleados);
		this.ordenes.add(orden);
		return orden;
	}
	
	public List<Factura> facturarOrdenes(){
		return ordenes.stream().map(orden -> orden.facturarOrden(0)).collect(Collectors.toList());
	}
}
