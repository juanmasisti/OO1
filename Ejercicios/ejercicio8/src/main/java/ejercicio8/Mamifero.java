package ejercicio8;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private java.time.LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	
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
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
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
	
	// a partir del mamífero actual (this), pregunta si unMamifero aparece en su árbol genealógico.
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return (tieneAncestro(this.getMadre(),unMamifero) || tieneAncestro(this.getPadre(),unMamifero));
	}

	// recibe parent(madre/padre) y devuelve true si son iguales con unMamifero, 
	// en caso de que no sea, va a seguir mirando recursivamente los padres de ese parent
	private boolean tieneAncestro (Mamifero parent, Mamifero unMamifero) {
		return ((parent != null) && (unMamifero.equals(parent) || parent.tieneComoAncestroA(unMamifero)));
	}
	
}
