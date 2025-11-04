package ejercicio24;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdenServicioTest {

	private Usuario juan;
	private Producto panelSolar, compostera, calefonSolar;
	private OrdenServicio servicio;
	private Tecnico lucia;
	
	@BeforeEach 
	void setUp() {
	    juan = new Usuario("Juan Martínez", "Larrea 5800, Mar del Plata");
	    panelSolar = new Producto("Panel solar", "reciclable", 35000, false);
	    compostera = new Producto("Compostera", "biodegradable", 8000, true);
	    calefonSolar = new Producto("Calefón solar", "reciclable", 50000, false);

	    lucia = new Tecnico("Lucía Iraola", "Instalaciones solares", 4500);
	    // Orden de servicio
	    servicio = new OrdenServicio(LocalDate.now(), juan, juan.getDomicilio(), "Instalacion panel solar", 10);
	}
	@Test
	void testOrdenServicioSinProductosYSinTecnico() {
		assertEquals(0, servicio.calcularCosto(), 0.01);
	}
	
	@Test
	void testOrdenServicioSinProductosConTecnico() {
		// 4500 * 10hs
		servicio.agregarTecnico(lucia);
		assertEquals(45000, servicio.calcularCosto(), 0.01);
	}
	
	@Test
	void testOrdenServicioConProductosConTecnico() {
		// (4500 * 10hs) + 50000
		servicio.agregarProducto(calefonSolar);
		servicio.agregarTecnico(lucia);
		assertEquals(95000, servicio.calcularCosto(), 0.01);
	}
	
	@Test
	void testOrdenServicioSinProductosConTecnicoMasDe10Horas() {
		// 4500 * 11hs
	    // 49500 * 0.9
	    OrdenServicio servicioB = new OrdenServicio(LocalDate.now(), juan, juan.getDomicilio(), "Instalacion panel solar", 11);
	    servicioB.agregarTecnico(lucia);
		assertEquals(44550, servicioB.calcularCosto(), 0.01);
	}
	
}
