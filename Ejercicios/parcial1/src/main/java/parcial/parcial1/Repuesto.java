package parcial.parcial1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Repuesto {
private String nombre;
private LocalDate fechaFabricacion;
private double costo;

public Repuesto(String nombre, LocalDate fechaFabricacion, double costo) {
	this.nombre = nombre;
	this.fechaFabricacion = fechaFabricacion;
	this.costo = costo;
}

public String getNombre() {
	return nombre;
}

public LocalDate getFechaFabricacion() {
	return fechaFabricacion;
}

public double getCosto() {
	return costo;
}

public boolean masDe5() {
	if (ChronoUnit.YEARS.between(fechaFabricacion, LocalDate.now()) > 5) {
		return true;
	}
	return false;
}


}
