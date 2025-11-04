package ejercicio24;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdenCompraTest {

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
	void testOrdenCompraSinProductos() {
		assertEquals(0, compra.calcularCosto(), 0.01);
	}
	
	@Test
	void testOrdenCompraConProductos() {
		compra.agregarProducto(calefonSolar);
		assertEquals(50000, compra.calcularCosto(), 0.01);
	}

	@Test
	void testOrdenCompraConProductosConDescuento() {
	    Producto termoPremium = new Producto("Termo", "reciclable", 5000, false);
	    Producto composteraPremium = new Producto("Compostera P", "reciclable", 2000, false);
		compra.agregarProducto(calefonSolar);
		compra.agregarProducto(compostera);
		compra.agregarProducto(panelSolar);
		compra.agregarProducto(termoPremium);
		compra.agregarProducto(composteraPremium);
		// descuento 10%
		//( 35000 + 8000 + 50000 + 5000 + 2000 ) * 0.9 = 90.000 
		assertEquals(90000, compra.calcularCosto(), 0.01);
	}
	
}
