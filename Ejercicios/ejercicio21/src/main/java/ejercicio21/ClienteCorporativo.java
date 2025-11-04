package ejercicio21;

public class ClienteCorporativo extends Cliente{
	private String cuil;
	
	public ClienteCorporativo(String cuil, String nombre, String direccion ) {
		super(nombre, direccion);
		this.cuil = cuil;
	}
	
	@Override
	public double descuento() {
		return 0;
	}


}
