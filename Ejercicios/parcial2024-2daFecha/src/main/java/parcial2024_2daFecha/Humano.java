package parcial2024_2daFecha;

import java.time.LocalTime;

public class Humano extends Personaje {
	public Humano(String nombre, Rol rol, int nivel, Habilidad habilidad) {
		super(nombre,rol,nivel);
		this.habilidad = new Habilidad(2, 1);
	}
	
	public double determinarPoderDeAtaque() {
		double valorBase = this.getRol().calcularValorBase(this.habilidad, this.getNivel());
		int hora = LocalTime.now().getHour(); ;
		if (hora >= 8 & hora <= 20) valorBase+=valorBase*0.4;
		return valorBase;
	}

	public double determinarPoderDeAtaque(int hora) {
		double valorBase = this.getRol().calcularValorBase(this.habilidad, this.getNivel());
		if (hora >= 20 && hora <= 8) valorBase+=valorBase*0.6;
		return valorBase;
	}
	
	@Override
	public void incrementarNivel() {
		this.nivel++;
		if (nivel >= 7) {
			this.getRol().incrementarHabilidad(this.habilidad, this.nivel);
			
		}
	}
	
}
