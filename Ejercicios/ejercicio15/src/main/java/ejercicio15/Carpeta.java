package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<Email>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Email> getEmails(){
		return this.emails;
	}
	public void mover(Email email, Carpeta destino) {
		this.quitar(email);
		destino.agregar(email);
	}
	
	public void agregar(Email e) {
		this.emails.add(e);
	}
    public void quitar(Email e) {
        emails.remove(e);
    }
    
    public int espacioOcupado() {
        return emails.stream().mapToInt(Email::tamanioTotal).sum();
    }

    public Email buscarPrimeroQueContenga(String texto) {
        for (Email e : emails) {
            if (e.contiene(texto)) return e;
        }
        return null;
    }
}

