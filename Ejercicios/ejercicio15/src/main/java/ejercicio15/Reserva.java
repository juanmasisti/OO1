package ejercicio15;

public class Reserva {
private Propiedad propiedad;
private DateLapse periodo;

public Reserva(DateLapse periodo, Propiedad propiedad) {
	this.periodo = periodo;
	this.propiedad = propiedad;
}

public double calcularReserva() {
	return periodo.sizeInDays() * propiedad.getPrecioPorNoche(); 
}

public boolean overlaps (DateLapse another) {
	return periodo.overlaps(another);
}

public boolean inicioPosteriorFechaActual() {
	return periodo.laterFrom();
	
}

}
