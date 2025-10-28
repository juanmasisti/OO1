package ejercicio19;

import java.time.LocalDate;

import ejercicio16.DateLapse;

public class Reserva {
    private DateLapse periodo;

    public Reserva(DateLapse periodo) {
        this.periodo = periodo;
    }

    public DateLapse getPeriodo() { 
    	return periodo; 
    }

    public double calcularPrecio(double precio) {
        return precio * periodo.sizeInDays();
    }

    public boolean superponeConPeriodo(DateLapse otroPeriodo) {
        return this.periodo.overlaps(otroPeriodo);
    }

    public void cancelar(Propiedad p) {
        if (!periodo.includesDate(LocalDate.now())) { // solo si NO está en curso
            p.eliminarReserva(this);
        } else {
            System.out.println("No se puede cancelar una reserva en curso.");
        }
    }

}
