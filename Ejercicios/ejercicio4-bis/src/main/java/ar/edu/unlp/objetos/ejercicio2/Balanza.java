package ar.edu.unlp.objetos.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private Ticket ticket;
	//Ahora tenemos coleccion de productos y calculamos datos desde esta coleccion 
	//en lugar de tener campos precioTotal, pesoTotal, cantidadDeProductos.
	private List<Producto> productos;
	
	public Balanza(List<Producto> productos) {
		this.productos = productos;
	}

	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}

	public List<Producto> getProductos(){
		return this.productos;
	}
	public void ponerEnCero() {
		this.productos.clear();
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
		
	}
	
    // Cambio importante: Cantidad, peso y precio calculados a partir de la lista
    public int getCantidadDeProductos() {
        return this.productos.size();
    }

    public double getPesoTotal() {
        return this.productos.stream()
                .mapToDouble(Producto::getPeso)
                .sum();
    }

    public double getPrecioTotal() {
        return this.productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

	public Ticket emitirTicket() {
		//Ahora se le pasa la lista de productos para instanciar el Ticket.
		ticket = new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(),this.getPrecioTotal(), this.getProductos());
		return ticket;
	}
}
