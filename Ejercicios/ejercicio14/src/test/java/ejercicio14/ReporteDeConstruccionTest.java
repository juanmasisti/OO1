package ejercicio14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {

    private ReporteDeConstruccion reporte;
    private Pieza cilindroHierroRojo;
    private Pieza esferaHierroAzul;
    private Pieza prismaMaderaRojo;

    @BeforeEach
    void setUp() {
        reporte = new ReporteDeConstruccion();
        cilindroHierroRojo = new Cilindro("Hierro", "Rojo", 2, 5);
        esferaHierroAzul = new Esfera("Hierro", "Azul", 3);
        prismaMaderaRojo = new PrismaRectangular("Madera", "Rojo", 2, 3, 4);

        reporte.agregarPieza(cilindroHierroRojo);
        reporte.agregarPieza(esferaHierroAzul);
        reporte.agregarPieza(prismaMaderaRojo);
    }

    @Test
    void testVolumenDeMaterialHierro() {
        double esperado = cilindroHierroRojo.calcularVolumen() + esferaHierroAzul.calcularVolumen();
        assertEquals(esperado, reporte.volumenDeMaterial("Hierro"), 0.001);
    }

    @Test
    void testSuperficieDeColorRojo() {
        double esperado = cilindroHierroRojo.calcularSuperficie() + prismaMaderaRojo.calcularSuperficie();
        assertEquals(esperado, reporte.superficieDeColor("Rojo"), 0.001);
    }

    @Test
    void testVolumenMaterialInexistente() {
        assertEquals(0.0, reporte.volumenDeMaterial("Plastico"));
    }

    @Test
    void testSuperficieColorInexistente() {
        assertEquals(0.0, reporte.superficieDeColor("Verde"));
    }
}
