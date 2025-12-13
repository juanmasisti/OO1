package parcial2024_1erFecha;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventoTest {
    
    private EventoPresencial eventoPresencial;
    private EventoVirtual eventoVirtual;
    private Sede sede;

    @BeforeEach
    void setUp() {
        // Evento el 20/12/2024
        eventoPresencial = new EventoPresencial("Congreso Sustentable",
                LocalDate.of(2024, 12, 20),
                "Ecología",
                10000, // inscripción
                2000   // remera
        );
        sede = new Sede("La Plata", 1500, 2); // 1500 * 2 = 3000
        eventoPresencial.agregarSede(sede);

        eventoVirtual = new EventoVirtual("Webinar Solar",
                LocalDate.of(2024, 12, 20),
                "Energías limpias",
                8000,
                1000,
                500   // envío remera
        );
    }

    @Test
    void testEventoPresencialConRecargo() {
        double esperado = (10000 * 1.2) + 2000 + 3000; // inscripción con recargo
        assertEquals(esperado, eventoPresencial.calcularPrecioAsistencia(LocalDate.of(2024, 12, 20)), 0.01);
    }

    @Test
    void testEventoPresencialSinRecargo() {
        double esperado = 10000 + 2000 + 3000;
        assertEquals(esperado, eventoPresencial.calcularPrecioAsistencia(LocalDate.of(2024, 12, 15)), 0.01);
    }

    @Test
    void testEventoVirtualConRecargo() {
        double esperado = (8000 * 1.2) + 1000 + 500;
        assertEquals(esperado, eventoVirtual.calcularPrecioAsistencia(LocalDate.of(2024, 12, 20)), 0.01);
    }

    @Test
    void testEventoVirtualSinRecargo() {
        double esperado = 8000 + 1000 + 500;
        assertEquals(esperado, eventoVirtual.calcularPrecioAsistencia(LocalDate.of(2024, 12, 10)), 0.01);
    }
}
