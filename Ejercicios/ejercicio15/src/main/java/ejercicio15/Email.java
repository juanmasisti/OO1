package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
	    this.titulo = titulo == null ? "" : titulo;
	    this.cuerpo = cuerpo == null ? "" : cuerpo;
		this.adjuntos = new ArrayList<Archivo>();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public List<Archivo> adjuntos() {
		return adjuntos;
	}
	public void agregarAdjunto(Archivo a) {
		this.adjuntos.add(a);
	}
    public int tamanioTotal() {
        int base = this.getTitulo().length() + this.getCuerpo().length();
        int extra = adjuntos.stream().mapToInt(Archivo::tamanio).sum();
        return base + extra;
    }
    public boolean contiene(String texto) {
    	return titulo.contains(texto) || cuerpo.contains(texto);
    }
}
