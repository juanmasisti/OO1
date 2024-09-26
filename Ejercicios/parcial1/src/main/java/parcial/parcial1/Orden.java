package parcial.parcial1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Orden {
private String patente;
private LocalDate fechaActual;
private List<Repuesto> repuestos;

public Orden(String patente, LocalDate fechaActual, List<Repuesto> respuestos) {
	this.patente = patente;
	this.fechaActual = fechaActual;
	this.repuestos = respuestos;
}

public String getPatente() {
	return patente;
}

public LocalDate getFechaActual() {
	return fechaActual;
}

public List<Repuesto> getRepuestos() {
	return repuestos;
}

public abstract double calcularMonto();
public abstract int calcularGanancia();
public Factura facturarOrden(double descuento) {
	double montoTotal = (((this.calcularMonto()*this.calcularGanancia())/100) + this.calcularMonto());
	montoTotal -=((montoTotal*descuento)/100);
	Factura factura = new Factura(LocalDate.now(),patente,montoTotal,descuento);
	return factura;
}
}

