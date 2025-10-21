package ejercicio13;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class PlazoFijo implements Inversion{
	private LocalDate fecha;
	private double tasa;
	private double monto;
	
	public PlazoFijo(LocalDate fecha, double monto, double tasa){
		this.fecha = fecha;
		this.tasa = tasa;
		this.monto = monto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getTasa() {
		return tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	
	public double getMonto(){
		return monto;
	}
	
	@Override
	public double calcularValor() {

        // Calcular cantidad de días transcurridos
        long dias = ChronoUnit.DAYS.between(this.getFecha(), LocalDate.now());

        // Calcular interés diario simple
        double interesDiario = monto * tasa / 365.0;

        return monto + (interesDiario * dias);

    }
	
	
}
