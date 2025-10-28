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
        Reserva r = new Reserva(periodo1);
        propiedad.agregarReserva(r);
        assertFalse(propiedad.estaDisponible(periodo1)); // se superpone
    }

    @Test
    void testCalcularIngresos() {
    	assertEquals(0, propiedad.calcularIngresos(periodo1),0.1);
        propiedad.agregarReserva(new Reserva(periodo1));
        assertEquals((5 * 100), propiedad.calcularIngresos(periodo1),0.1);
    	assertEquals(0, propiedad.calcularIngresos(periodo2),0.1);

    }
}
