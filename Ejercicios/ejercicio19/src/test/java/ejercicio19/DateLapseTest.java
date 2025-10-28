package ejercicio19;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ejercicio16.DateLapse;

public class DateLapseTest {
    private DateLapse periodo, periodoSuperpuesto, periodoDisjunto;

    @BeforeEach
    void setUp() {
        periodo = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5)); // 4 días
        periodoSuperpuesto = new DateLapse(LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 8));
        periodoDisjunto = new DateLapse(LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 15));
    }

    @Test
    void testSizeInDays() {
        assertEquals(4, periodo.sizeInDays());
    }

    @Test
    void testIncludesDate() {
        assertTrue(periodo.includesDate(LocalDate.of(2025, 1, 1))); // borde inferior
        assertTrue(periodo.includesDate(LocalDate.of(2025, 1, 4))); // intermedio
        assertFalse(periodo.includesDate(LocalDate.of(2025, 1, 6))); // fuera de rango
    }

    @Test
    void testOverlaps() {
        assertTrue(periodo.overlaps(periodoSuperpuesto)); // se superponen
        assertFalse(periodo.overlaps(periodoDisjunto));   // no se superponen
    }
}
