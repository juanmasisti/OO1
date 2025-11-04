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

    public double cancelar(Propiedad p) { // ej20. se añadió funcinalidad de retornar el monto a reembolsar por cancelación según politica correspondiente.
        if (!periodo.includesDate(LocalDate.now())) { // solo si NO está en curso
            double reembolso = p.getPoliticaC().calcularReembolso(this, p);
            p.eliminarReserva(this);
            return reembolso;
            
        } else {
            return 0;
        }
    }

}
