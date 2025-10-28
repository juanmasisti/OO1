package ejercicio19;

import java.time.LocalDate;

import ejercicio16.DateLapse;

public class Reserva {
    private DateLapse periodo;
    private Propiedad propiedad;

    public Reserva(DateLapse periodo, Propiedad propiedad) {
        this.periodo = periodo;
        this.propiedad = propiedad;
    }

    public DateLapse getPeriodo() { 
    	return periodo; 
    }

    public double calcularPrecio() {
        return propiedad.getPrecioPorNoche() * periodo.sizeInDays();
    }

    public boolean superponeConPeriodo(DateLapse otroPeriodo) {
        return this.periodo.overlaps(otroPeriodo);
    }

    public void cancelar() {
        if (!periodo.includesDate(LocalDate.now())) { // solo si NO está en curso
            propiedad.eliminarReserva(this);
        } else {
            System.out.println("No se puede cancelar una reserva en curso.");
        }
    }

}
