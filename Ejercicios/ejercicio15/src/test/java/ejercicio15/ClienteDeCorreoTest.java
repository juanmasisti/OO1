package ejercicio15;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {

    private ClienteDeCorreo cliente;
    private Carpeta trabajo, personal;
    private Email e1, e2, e3;

    @BeforeEach
    void setUp() {
        cliente = new ClienteDeCorreo();
        trabajo = new Carpeta("Trabajo");
        personal = new Carpeta("Personal");
        cliente.agregarCarpeta(trabajo);
        cliente.agregarCarpeta(personal);

        e1 = new Email("Reunión", "Agenda 10:00 con equipo");
        e1.agregarAdjunto(new Archivo("orden_del_dia.pdf"));   // tamaño 17

        e2 = new Email("Factura", "Adjunto pago");
        e2.agregarAdjunto(new Archivo("fac_1234.pdf"));        // tamaño 12
        e2.agregarAdjunto(new Archivo("comprobante.png"));     // tamaño 15

        e3 = new Email("Vacaciones", "Información de hotel");

        cliente.recibir(e1);         // a Inbox
        trabajo.agregar(e2);
        personal.agregar(e3);
    }

    @Test
    void recibirAlInbox() {
        Email nuevo = new Email("Hola", "Mundo");
        cliente.recibir(nuevo);
        assertTrue(cliente.getInbox().getEmails().contains(nuevo));
    }

    @Test
    void moverEntreCarpetas() {
        // mover e2 de Trabajo -> Personal
        cliente.mover(e2, trabajo, personal);
        assertFalse(trabajo.getEmails().contains(e2));
        assertTrue(personal.getEmails().contains(e2));
    }

    @Test
    void buscarPorTituloOCuerpoDevuelveElPrimero() {
        // En orden de búsqueda: Inbox, Trabajo, Personal
        assertEquals(e1, cliente.buscar("Reunión"));          // título
        assertEquals(e2, cliente.buscar("Adjunto"));          // cuerpo
        assertEquals(e3, cliente.buscar("hotel"));            // cuerpo (sensible a mayúsculas: "hotel" está exacto)
        assertNull(cliente.buscar("no-existe"));
    }

    @Test
    void tamanioEmailSeCalculaConTituloCuerpoYAdjuntos() {
        int tamE1 = e1.getTitulo().length() + e1.getCuerpo().length() + 17;
        assertEquals(tamE1, e1.tamanioTotal(), 0.1);

        int tamE2 = e2.getTitulo().length() + e2.getCuerpo().length() + 12 + 15;
        assertEquals(tamE2, e2.tamanioTotal(), 0.1);

        int tamE3 = e3.getTitulo().length() + e3.getCuerpo().length(); // sin adjuntos
        assertEquals(tamE3, e3.tamanioTotal(), 0.1);
    }

    @Test
    void espacioOcupadoSumaTodasLasCarpetas() {
        int esperado = cliente.getInbox().espacioOcupado()
                      + trabajo.espacioOcupado()
                      + personal.espacioOcupado();
        assertEquals(esperado, cliente.espacioOcupado());
    }

    @Test
    void casosBorde() {
        // cliente vacío
        ClienteDeCorreo vacio = new ClienteDeCorreo();
        assertEquals(0, vacio.espacioOcupado());
        assertNull(vacio.buscar("algo"));

        // archivo sin nombre
        Email e = new Email("", "");
        e.agregarAdjunto(new Archivo(""));
        assertEquals(0, e.tamanioTotal());
    }
}
