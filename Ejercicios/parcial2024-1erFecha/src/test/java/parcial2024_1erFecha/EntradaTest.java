package parcial2024_1erFecha;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntradaTest {

    private EventoVirtual evento;
    private LocalDate fechaEvento;
    private LocalDate fechaCompra;
    
    @BeforeEach
    void setUp() {
        fechaEvento = LocalDate.of(2024, 12, 20);
        fechaCompra = LocalDate.of(2024, 11, 10);
        evento = new EventoVirtual("Webinar Solar", fechaEvento, "Energías limpias", 8000, 1000, 500);
    }

    @Test
    void testSinSeguroConDifMenorA30() {
        Entrada entrada = new Entrada(false, LocalDate.of(2024, 12, 1), evento); // 19 días antes
        assertEquals(0, entrada.calcularMontoARecuperar(), 0.01);
    }

    @Test
    void testConSeguroConDifMenorA30() {
        Entrada entrada = new Entrada(true, LocalDate.of(2024, 12, 1), evento); // 19 días antes
        assertEquals(0, entrada.calcularMontoARecuperar(), 0.01);
    }

    @Test
    void testSinSeguroConDifIgualA30() {
        Entrada entrada = new Entrada(false, LocalDate.of(2024, 11, 20), evento); // 30 días antes
        double precioBase = evento.calcularPrecioAsistencia(entrada.getFechaCompra());
        assertEquals(precioBase * 0.5, entrada.calcularMontoARecuperar(), 0.01);
    }

    @Test
    void testConSeguroConDifIgualA30() {
        Entrada entrada = new Entrada(true, LocalDate.of(2024, 11, 20), evento); // 30 días antes
        double precioBase = evento.calcularPrecioAsistencia(entrada.getFechaCompra());
        assertEquals(precioBase * 0.65, entrada.calcularMontoARecuperar(), 0.01);
    }

    @Test
    void testConSeguroConDifMayorA30() {
        Entrada entrada = new Entrada(true, LocalDate.of(2024, 10, 20), evento); // 60 días antes
        double precioBase = evento.calcularPrecioAsistencia(entrada.getFechaCompra());
        assertEquals(precioBase * 0.65, entrada.calcularMontoARecuperar(), 0.01);
    }
}
