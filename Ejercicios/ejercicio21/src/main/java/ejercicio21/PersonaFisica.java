package ejercicio21;

public class PersonaFisica extends Cliente{
	private String dni;

	public PersonaFisica(String dni, String nombre, String direccion ) {
		super(nombre, direccion);
		this.dni = dni;
	}
	
	public double descuento() {
		return 0.1;
	}
}
