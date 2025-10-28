package ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {

    private Inversor inversor;
    private Accion accion1;
    private Accion accion2;
    private PlazoFijo plazoFijo;
    
    //Se ejecuta antes de cada test
    @BeforeEach
    void setUp() {
        inversor = new Inversor();
        accion1 = new Accion(100.0, "Apple", 10); // valor = 1000
        accion2 = new Accion(50.0, "Tesla", 4);   // valor = 200
        plazoFijo = new PlazoFijo(LocalDate.now(), 500, 0.2); // dias transcurridos 0, valor = 500, tasa = 20% anual
    }

    //Cada test es independiente, JUnit crea una nueva instancia de la clase de test para cada método.
    @Test
    void testAgregarInversion() {
        inversor.agregar(accion1);
        assertTrue(inversor.getInversiones().contains(accion1));


    }

    @Test 
    void testQuitarInversion() {
    	inversor.agregar(accion1);
        inversor.quitar(accion1);
        assertFalse(inversor.getInversiones().contains(accion1));
    }
    @Test
    void testCalculoDeValorDeAccion() {
        assertEquals(1000.0, accion1.calcularValor());
    }

    @Test
    void testCalculoValorTotalDeInversor() {
        inversor.agregar(accion1);
        inversor.agregar(accion2);
        inversor.agregar(plazoFijo);
        assertEquals(1700.0, inversor.valorTotal());
    }

    @Test
    void testInversorSinInversiones() {
    	// no hace falta quitar, porque cada test empieza con lista vacia
        assertEquals(0.0, inversor.valorTotal());
    }
}
