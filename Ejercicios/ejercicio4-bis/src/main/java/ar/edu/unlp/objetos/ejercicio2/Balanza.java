package ar.edu.unlp.objetos.ejercicio2;

public class Balanza {
	private Integer cantidadProductos;
	private double precioTotal;
	private double pesoTotal;
	private Ticket ticket;
	
	public Balanza(Integer cantidadProductos, double precioTotal, double pesoTotal) {
		this.cantidadProductos = cantidadProductos;
		this.precioTotal = precioTotal;
		this.pesoTotal = pesoTotal;
	}

	public Integer getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(Integer cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	

	public void ponerEnCero() {
		this.cantidadProductos = 0;
		this.pesoTotal = 0;
		this.precioTotal = 0;
		
	}
	
	public void agregarProducto(Producto producto) {
		this.setCantidadProductos(cantidadProductos+1);
		
	}
	
	public Ticket emitirTicket() {
		ticket = new Ticket(this.cantidadProductos, this.pesoTotal, this.pesoTotal);
		return ticket;
	}
}
