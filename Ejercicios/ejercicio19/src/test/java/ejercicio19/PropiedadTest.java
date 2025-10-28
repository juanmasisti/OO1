package ejercicio19;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ejercicio16.DateLapse;

public class PropiedadTest {
    private Propiedad propiedad;
    private DateLapse periodo1, periodo2, periodoSolapado;

    @BeforeEach
    void setUp() {
        propiedad = new Propiedad("Calle 65", "Depto A", 100);
        periodo1 = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5)); // 5 dias
        periodo2 = new DateLapse(LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 15));
        periodoSolapado = new DateLapse(LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 8));
    }

    @Test
    void testPropiedadDisponibleYNoDisponible() {
        assertTrue(propiedad.estaDisponible(periodo1));
        Reserva r = new Reserva(periodo1, propiedad);
        propiedad.agregarReserva(r);
        assertFalse(propiedad.estaDisponible(periodoSolapado)); // se superpone
    }

    @Test
    void testCalcularIngresos() {
        propiedad.agregarReserva(new Reserva(periodo1, propiedad));
        propiedad.agregarReserva(new Reserva(periodo2, propiedad));
        DateLapse rango = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 20));
        assertEquals(0.75 * ((4 * 100) + (5 * 100)), propiedad.calcularIngresos(rango));
    }
}
