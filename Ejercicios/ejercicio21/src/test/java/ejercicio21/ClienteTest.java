package ejercicio21;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    private PersonaFisica persona;
    private ClienteCorporativo corporativo;

    @BeforeEach
    void setUp() {
        persona = new PersonaFisica("12345678", "Juan Pérez", "La Plata");
        corporativo = new ClienteCorporativo("30-55555555-9", "ACME S.A.", "CABA");
    }

    // ---- TEST DESCUENTO ----
    @Test
    void testDescuentoPersonaFisicaYCorporativo() {
        assertEquals(0.1, persona.descuento(), 0.001);
        assertEquals(0.0, corporativo.descuento(), 0.001);
    }

    // ---- TEST MONTO TOTAL ----
    @Test
    void testMontoTotalSinEnvios() {
        double total = persona.montoTotal(LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(0.0, total, 0.001);
    }

    @Test
    void testMontoTotalConEnviosDentroDelPeriodo() {
        persona.agregarEnvio(new EnvioLocal("A", "B", 200, LocalDate.now(), false)); // $1000
        persona.agregarEnvio(new EnvioLocal("A", "B", 200, LocalDate.now(), true));  // $1500
        double total = persona.montoTotal(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertEquals(2250.0, total, 0.001); // (1000 + 1500) * 0.9
    }

    @Test
    void testMontoTotalFueraDePeriodoDebeSerCero() {
        persona.agregarEnvio(new EnvioLocal("A", "B", 200, LocalDate.now(), false));
        double total = persona.montoTotal(LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
        assertEquals(0.0, total, 0.001);
    }

    @Test
    void testMontoTotalClienteCorporativoSinDescuento() {
        corporativo.agregarEnvio(new EnvioLocal("A", "B", 200, LocalDate.now(), false)); // $1000
        corporativo.agregarEnvio(new EnvioLocal("A", "B", 200, LocalDate.now(), true));  // $1500
        double total = corporativo.montoTotal(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertEquals(2500.0, total, 0.001); // sin descuento
    }
}
