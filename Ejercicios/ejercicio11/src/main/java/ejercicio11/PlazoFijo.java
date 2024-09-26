package ejercicio11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo {
	LocalDate fechaDeConstitucion;
	double montoDepositado;
	double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}
	public void setFechaDeConstitucion(LocalDate fechaDeConstitucion) {
		this.fechaDeConstitucion = fechaDeConstitucion;
	}
	public double getMontoDepositado() {
		return montoDepositado;
	}
	public void setMontoDepositado(double montoDepositado) {
		this.montoDepositado = montoDepositado;
	}
	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}
	public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public double valorActual() {
		long dias = ChronoUnit.DAYS.between(this.getFechaDeConstitucion(), LocalDate.now()); // ESTE ME DA LOS DIAS EN CALENDARIO
		return this.getMontoDepositado() + (this.getMontoDepositado() * this.getPorcentajeDeInteresDiario() * dias);
	}
}
