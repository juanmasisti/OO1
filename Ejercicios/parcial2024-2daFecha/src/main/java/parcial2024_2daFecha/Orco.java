package parcial2024_2daFecha;

import java.time.LocalTime;

public class Orco extends Personaje {
	public Orco(String nombre, Rol rol, int nivel) {
		super(nombre,rol,nivel);
		this.habilidad = new Habilidad(1,2);
		
	}
	
	public double determinarPoderDeAtaque() {
		double valorBase = this.getRol().calcularValorBase(this.habilidad, this.getNivel());
		int hora = LocalTime.now().getHour(); ;
		if (hora >= 20 || hora <= 8) valorBase+=valorBase*0.6;
		return valorBase;
	}
	@Override
	
	public double determinarPoderDeAtaque(int hora) {
		double valorBase = this.getRol().calcularValorBase(this.habilidad, this.getNivel());
		if (hora >= 20 || hora < 8) valorBase+=valorBase*0.6;
		return valorBase;
	}
	
	
	@Override
	public void incrementarNivel() {
		this.nivel++;
		if (this.nivel % 3 == 0) {
			this.getRol().incrementarHabilidad(this.habilidad, this.nivel);
		}
	}
	
}