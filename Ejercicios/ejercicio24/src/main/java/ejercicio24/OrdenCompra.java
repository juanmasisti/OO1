package ejercicio24;

import java.time.LocalDate;

public class OrdenCompra extends Orden {
    private double precioEnvio;

    public OrdenCompra(LocalDate fecha, Usuario usuario, String domicilio, double precioEnvio) {
        super(fecha, usuario, domicilio);
        this.precioEnvio = precioEnvio;
    }

    @Override
    public double calcularCosto() {
        double total = this.getProductos().stream()
                .mapToDouble(Producto::getCosto)
                .sum() + precioEnvio;

        // Descuento del 10% si tiene 5 o más productos
        if (this.getProductos().size() >= 5) {
            total *= 0.9;
        }
        return total;
    }
}
