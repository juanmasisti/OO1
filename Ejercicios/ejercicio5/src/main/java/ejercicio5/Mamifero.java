package ejercicio5;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private java.time.LocalDate fechaNacimiento;
	private Mamifero Padre;
	private Mamifero Madre;
	
	
	// Constructors
	public Mamifero(String identificador) {
		this.identificador = identificador;
	
	}

	public Mamifero() {
		
	}
	
	// Getters and Setters
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String id) {
		this.identificador = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public java.time.LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(java.time.LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}

	public Mamifero getPadre() {
		return Padre;
	}

	public void setPadre(Mamifero padre) {
		Padre = padre;
	}

	public Mamifero getMadre() {
		return Madre;
	}

	public void setMadre(Mamifero madre) {
		Madre = madre;
	}
	
	// Methods
	
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null)
			return this.getMadre().getMadre();
		return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null)
			return this.getMadre().getPadre() ;
		return null;
	}

	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null)
			return this.getPadre().getMadre() ;
		return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null)
			return this.getPadre().getPadre() ;
		return null;	
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return (tieneAncestro(this.getMadre(),unMamifero) || tieneAncestro(this.getPadre(),unMamifero));
	}

	
	private boolean tieneAncestro (Mamifero parent, Mamifero unMamifero) {
		return ((parent != null) && (unMamifero.equals(parent) || parent.tieneComoAncestroA(unMamifero)));
	}
	
}
