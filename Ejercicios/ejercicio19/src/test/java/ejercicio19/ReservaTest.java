package ejercicio19;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ejercicio16.DateLapse;

public class ReservaTest {
    private Reserva reserva;
    private Propiedad propiedad;
    private Usuario usuario;
    private DateLapse periodo;

    @BeforeEach
    void setUp() {
        propiedad = new Propiedad("Calle 1", "Casa", 200);
        usuario = new Usuario("Pedro", "Av. 1", "4563111");
        periodo = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 4)); // 3 noches
        reserva = new Reserva(periodo, propiedad);
        propiedad.agregarReserva(reserva);
    }

    @Test
    void testCalcularPrecio() {
        assertEquals(600, reserva.calcularPrecio()); // 3 * 200
    }

    @Test
    void testSuperposicionDePeriodos() {
        DateLapse solapado = new DateLapse(LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 5));
        DateLapse disjunto = new DateLapse(LocalDate.of(2025, 2, 1), LocalDate.of(2025, 2, 3));
        assertTrue(reserva.superponeConPeriodo(solapado));
        assertFalse(reserva.superponeConPeriodo(disjunto));
    }

    @Test
    void testCancelarReservaFutura() {
        // para simular una reserva futura, elegimos fechas posteriores a hoy
        LocalDate inicio = LocalDate.now().plusDays(10);
        LocalDate fin = inicio.plusDays(5);
        Reserva futura = new Reserva(new DateLapse(inicio, fin), propiedad);
        propiedad.agregarReserva(futura);
        futura.cancelar(); // debería eliminarse
        assertTrue(propiedad.estaDisponible(new DateLapse(inicio, fin)));
    }
    
    @Test
    void testCancelarReservaEnCurso() {
    	DateLapse periodoEnCurso = new DateLapse(LocalDate.now(), LocalDate.now().plusDays(5));
        Reserva futura = new Reserva(periodoEnCurso, propiedad);
        propiedad.agregarReserva(futura);
        futura.cancelar(); // no debería poder eliminarse
        assertFalse(propiedad.estaDisponible(periodoEnCurso));
    }
}
