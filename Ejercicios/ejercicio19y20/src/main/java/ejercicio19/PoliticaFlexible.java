package ejercicio19;

import java.time.LocalDate;

public class PoliticaFlexible implements PoliticaCancelacion{
	@Override
    public double calcularReembolso(Reserva reserva, Propiedad p) {
        LocalDate hoy = LocalDate.now();
        // Solo si no ha iniciado la reserva
        if (hoy.isBefore(reserva.getPeriodo().getFrom())) {
            return reserva.calcularPrecio(p.getPrecioPorNoche()); // 100%
        }
        return 0;
    }
}
