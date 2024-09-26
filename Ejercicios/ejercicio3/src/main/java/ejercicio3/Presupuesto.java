package ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private java.time.LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto() {
		this.fecha = LocalDate.now();
		this.setItems(new ArrayList<Item>());
	}
	public Presupuesto(java.time.LocalDate fecha, String cliente, List<Item> items ) {
		this.fecha = fecha;
		this.cliente = cliente;
		this.setItems(items);
	}

	public java.time.LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Presupuesto cliente(String cliente) {
		this.setCliente(cliente);
		return this;
	}
	
	public double calcularTotal() {
		return this.items.stream().mapToDouble(item -> item.costo()).sum();
	}

	public void agregarItem(Item item) {
		this.items.add(item);	
	}
}
