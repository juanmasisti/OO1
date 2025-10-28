package ejercicio19;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicio16.DateLapse;

class UsuarioTest {
    private Usuario propietario;
    private Usuario cliente;
    private Propiedad propiedad;
    private DateLapse periodo;
    
    @BeforeEach
    void setUp() {
    	propietario = new Usuario("Juan", "12 nro 1532", "44519221");
    	cliente = new Usuario("Maria", "1 nro 1923", "15612123");
    	propiedad = new Propiedad("Calle 10 nro 2313", "Depto B", 150);
        propietario.agregarPropiedad(propiedad);
        periodo = new DateLapse(LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 4)); // 3 días
    	
    }
    @Test
    void testReservarPropiedadDisponible() {
        Reserva reserva = cliente.reservar(propiedad, periodo);
        assertNotNull(reserva);
        assertEquals((150 * 3), propiedad.calcularIngresos(periodo), 0.01); // 150 x 3 días y sacamos el 0.75 que hace la funcion calcularIngresos().
    }

    @Test
    void testReservarPropiedadNoDisponible() {
        cliente.reservar(propiedad, periodo); // primera reserva
        DateLapse solapado = new DateLapse(LocalDate.of(2025, 3, 2), LocalDate.of(2025, 3, 5));
        Reserva otra = cliente.reservar(propiedad, solapado);
        assertNull(otra); // no deberia estar disponible, por lo tanto deberia ser null
    }

    @Test
    void testCalcularIngresosPropietarioConReservas() {
        cliente.reservar(propiedad, periodo);
        DateLapse rango = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31));
        assertEquals(0.75 * (3 * 150), propietario.calcularIngresos(rango), 0.01);
    }
    
    @Test
    void testCalcularIngresosPropietarioSinReservas() {
        //cliente.reservar(propiedad, periodo);
        DateLapse rango = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31));
        assertEquals(0, propietario.calcularIngresos(rango), 0.01);
    }
    @Test
    void testCalcularIngresosPropietarioSinReservasEnPeriodo() {
        cliente.reservar(propiedad, periodo);
        DateLapse rango = new DateLapse(LocalDate.of(2027, 2, 1), LocalDate.of(2027, 12, 31));
        assertEquals(0, propietario.calcularIngresos(rango), 0.1);
    }
    
}
