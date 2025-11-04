package ejercicio19;

public class PoliticaEstricta implements PoliticaCancelacion {
	@Override
	public double calcularReembolso(Reserva reserva, Propiedad p) {
	    return 0;
	}
}
