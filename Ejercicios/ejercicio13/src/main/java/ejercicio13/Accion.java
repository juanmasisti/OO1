package ejercicio13;

public class Accion implements Inversion{
	private double valorUnitario;
	private String nombre;
	private int cant;
	
	public Accion(double valorUnitario, String nombre, int cant) {
		this.valorUnitario = valorUnitario;
		this.nombre = nombre;
		this.cant = cant;
	}
	
	public double calcularValor(){
		return this.getValorUnitario() * this.getCant();
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
	
}
