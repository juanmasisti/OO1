package ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class Inversor {
	private List<Inversion> inversiones; 
	
	
	public Inversor() {
		this.inversiones = new ArrayList<>();
	}
	
	public void agregar(Inversion inv) {
		this.inversiones.add(inv);	}
	
	public void quitar(Inversion inv) {
		this.inversiones.remove(inv);
	}
	
	public double valorTotal() {
		return inversiones.stream()
	               .mapToDouble(Inversion::calcularValor)
	               .sum();
	}

	public List<Inversion> getInversiones() {
		return inversiones;
	}


}
