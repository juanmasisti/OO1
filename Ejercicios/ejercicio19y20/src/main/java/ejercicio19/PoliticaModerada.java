package ejercicio19;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements PoliticaCancelacion {
	@Override
    public double calcularReembolso(Reserva reserva, Propiedad p) {
        LocalDate hoy = LocalDate.now();
        LocalDate inicio = reserva.getPeriodo().getFrom();
        long diasHastaInicio = ChronoUnit.DAYS.between(hoy, inicio);

        if (diasHastaInicio >= 7)
            return reserva.calcularPrecio(p.getPrecioPorNoche());       // con 7 o más dias hata el inicio -> 100%
        else if (diasHastaInicio >= 2)
            return reserva.calcularPrecio(p.getPrecioPorNoche()) * 0.5; // con 2 o más dias hata el inicio -> 50%
        else
            return 0; // menos de 2 días → sin reembolso
    }
}
