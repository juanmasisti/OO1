package parcial2024_1erFecha;

public class Sede {
	private String nombre;
	private double precioPorDia;
	private int cantDias;
	
	public Sede(String nombre, double precioPorDia, int cantDias) {
		this.nombre = nombre;
		this.precioPorDia = precioPorDia;
		this.cantDias = cantDias;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecioPorDia() {
		return precioPorDia;
	}

	public int getCantDias() {
		return cantDias;
	}
	
	
}
