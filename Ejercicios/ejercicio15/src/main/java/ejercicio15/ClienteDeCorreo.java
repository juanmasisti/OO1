package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	Carpeta inbox;
	List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta("Inbox");
		this.carpetas = new ArrayList<Carpeta>();
		this.carpetas.add(inbox);
	}

	public Carpeta getInbox() {
		return inbox;
	}

	public List<Carpeta> getCarpetas() {
		return carpetas;
	}
	public void agregarCarpeta(Carpeta c) {
		this.carpetas.add(c);
	}
	public void recibir(Email email) {
		this.inbox.agregar(email);
	}
	
	 public Email buscar(String texto) {
	        for (Carpeta c : carpetas) {
	            Email hallado = c.buscarPrimeroQueContenga(texto);
	            if (hallado != null) return hallado;
	        }
	        return null;
	    }
	 
	 public int espacioOcupado() {
	       return carpetas.stream().mapToInt(Carpeta::espacioOcupado).sum();
	 }

	 public void mover(Email email, Carpeta origen, Carpeta destino) {
	      origen.mover(email, destino);
	 }

}
