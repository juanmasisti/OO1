package parcial2024_2daFecha;

import java.util.List;

public abstract class Personaje {
	private String nombre;
	private Rol rol;
	protected int nivel;
	protected Habilidad habilidad;
	
	public Personaje(String nombre, Rol rol, int nivel) {
		this.nombre = nombre;
		this.rol = rol;
		this.nivel = nivel;
	}
	public String getNombre() {
		return nombre;
	}
	public Rol getRol() {
		return rol;
	}
	public int getNivel() {
		return nivel;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public void efrentamientoUnoaUno(Personaje oponente) {
		double miPoder = this.determinarPoderDeAtaque();
		double oponentePoder = oponente.determinarPoderDeAtaque();
		
		if (miPoder>oponentePoder) this.incrementarNivel();
		else if (oponentePoder>miPoder) oponente.incrementarNivel();
		else {
			this.incrementarNivel();
			oponente.incrementarNivel();
		}
	}
	
	public List<Personaje> buscarOponentes(List<Personaje> oponentes) {
	    return oponentes.stream()
	        .filter(o -> {
	            int diffNivel = Math.abs(o.getNivel() - this.getNivel());
	            
	            if (diffNivel == 0) { // Si el nivel es igual, aplicás la comparación de poder de ataque.
	                // misma diferencia de nivel → comparar poder de ataque a las 12 hs
	                double poderO = o.determinarPoderDeAtaque(12);
	                double poderThis = this.determinarPoderDeAtaque(12);
	                return Math.abs(poderO - poderThis) < 5;
	            } else { // Si es distinto, verificás que la diferencia ≤ 2.
	                // otros casos → diferencia de nivel ≤ 2
	                return diffNivel <= 2;
	            }
	        })
	        .toList(); // o .collect(Collectors.toList()) si usás Java <16
	}
	public abstract double determinarPoderDeAtaque();
	public abstract double determinarPoderDeAtaque(int hora);
	public abstract void incrementarNivel();
	
}
