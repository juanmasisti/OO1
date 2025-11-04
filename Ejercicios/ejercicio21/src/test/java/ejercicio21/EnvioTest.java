package ejercicio21;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class EnvioTest {

    // ---- ENVÍO LOCAL ----
    @Test
    void testEnvioLocalEstandar() {
        EnvioLocal e = new EnvioLocal("La Plata", "La Plata", 200, LocalDate.now(), false);
        assertEquals(1000, e.calcularCosto(), 0.001);
    }

    @Test
    void testEnvioLocalRapido() {
        EnvioLocal e = new EnvioLocal("La Plata", "La Plata", 200, LocalDate.now(), true);
        assertEquals(1500, e.calcularCosto(), 0.001);
    }

    // ---- ENVÍO INTERURBANO ----
    @Test
    void testEnvioInterurbanoMenosDe100Km() {
        EnvioInterurbano e = new EnvioInterurbano("A", "B", 10, LocalDate.now(), 80);
        assertEquals(200, e.calcularCosto(), 0.001);
    }

    @Test
    void testEnvioInterurbanoEntre100Y500Km() {
        EnvioInterurbano e = new EnvioInterurbano("A", "B", 10, LocalDate.now(), 300);
        assertEquals(250, e.calcularCosto(), 0.001);
    }

    @Test
    void testEnvioInterurbanoMasDe500Km() {
        EnvioInterurbano e = new EnvioInterurbano("A", "B", 10, LocalDate.now(), 600);
        assertEquals(300, e.calcularCosto(), 0.001);
    }

    // ---- ENVÍO INTERNACIONAL ----
    @Test
    void testEnvioInternacionalMenorA1KgSinRapido() {
        EnvioInternacional e = new EnvioInternacional("A", "B", 500, LocalDate.now(), false);
        assertEquals(5000 + (500 * 10), e.calcularCosto(), 0.001);
    }

    @Test
    void testEnvioInternacionalMayorA1KgSinRapido() {
        EnvioInternacional e = new EnvioInternacional("A", "B", 1500, LocalDate.now(), false);
        assertEquals(5000 + (1500 * 12), e.calcularCosto(), 0.001);
    }

    @Test
    void testEnvioInternacionalMayorA1KgConRapido() {
        EnvioInternacional e = new EnvioInternacional("A", "B", 1500, LocalDate.now(), true);
        assertEquals(5000 + (1500 * 12) + 800, e.calcularCosto(), 0.001);
    }
}
