package ejercicio24;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestDeInstancia {
	private Usuario juan;
	private Producto panelSolar, compostera, calefonSolar;
	private OrdenCompra compra;
	private Tecnico lucia;
	
	@BeforeEach 
	void setUp() {
	    juan = new Usuario("Juan Martínez", "Larrea 5800, Mar del Plata");

	    panelSolar = new Producto("Panel solar", "reciclable", 35000, false);
	    compostera = new Producto("Compostera", "biodegradable", 8000, true);
	    calefonSolar = new Producto("Calefón solar", "reciclable", 50000, false);

	    lucia = new Tecnico("Lucía Iraola", "Instalaciones solares", 4500);
	    // Orden de compra
	    compra = new OrdenCompra(LocalDate.now(), juan, juan.getDomicilio(), 0);
	}
	@Test
	void testCalculosOrdenesDeJuanMartinez() {
	    compra.agregarProducto(panelSolar);
	    compra.agregarProducto(compostera);

	    // Orden de servicio
	    OrdenServicio servicio = new OrdenServicio(LocalDate.now(), juan, juan.getDomicilio(),
	            "Instalación de calefón solar", 5);
	    servicio.agregarTecnico(lucia);
	    servicio.agregarProducto(calefonSolar);

	    // Agregar a Juan
	    juan.agregarOrden(compra);
	    juan.agregarOrden(servicio);

	    assertEquals(43000, compra.calcularCosto(), 0.01);
	    assertEquals(72500, servicio.calcularCosto(), 0.01);
	}

}
