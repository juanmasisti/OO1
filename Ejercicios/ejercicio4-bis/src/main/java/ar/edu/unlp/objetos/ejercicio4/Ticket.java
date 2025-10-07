package ar.edu.unlp.objetos.ejercicio4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	// Se agrega campo para que el ticker conozca a los productos.
	private List<Producto> productos;
	
	public Ticket(	int cantidadDeProductos, double pesoTotal, double precioTotal, List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
		this.productos = productos;
	}

	public Ticket() {
	    this.fecha = LocalDate.now();
	    this.productos = new ArrayList<>();
	}
	  
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
    // nueva responsabilidad: devolver productos del ticket (no modificables desde afuera)
    public List<Producto> getProductos() {
        return Collections.unmodifiableList(this.productos);
    }
	
	public double impuesto() {
		return (this.getPrecioTotal()*0.21);
	}
	

}
