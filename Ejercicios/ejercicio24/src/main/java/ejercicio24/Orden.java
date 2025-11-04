package ejercicio24;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Orden {
    private LocalDate fecha;
    private Usuario usuario;
    private String domicilio;
    private List<Producto> productos;

    public Orden(LocalDate fecha, Usuario usuario, String domicilio) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.domicilio = domicilio;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public List<Producto> getProductos(){
    	return this.productos;
    }

    public abstract double calcularCosto();
}
