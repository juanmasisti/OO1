# Resolución - Examen Final OO1 (8 de Febrero de 2024)

## Ejercicio 1. Análisis y Diseño

### a) Problemas identificados en el código
El código provisto presenta los siguientes errores graves de diseño:

1. **Falta de Encapsulamiento:** Las variables de instancia de la clase `Producto` (`tipo`, `horasTrabajadas`, etc.) están declaradas como `public`. El estado interno de los objetos debe estar siempre oculto declarando las variables como `private`.
2. **Ausencia de Polimorfismo / Abuso de condicionales (Type Codes):** En la clase `Pedido`, el método `costo(Producto producto)` utiliza sentencias `if` para preguntar por el atributo `tipo` del producto (código de tipo) y decidir qué fórmula aplicar. Esto rompe la extensibilidad y debe resolverse delegando el comportamiento mediante Polimorfismo.
3. **Mala asignación de responsabilidades (Violación del patrón Experto):** La clase `Pedido` está realizando cálculos matemáticos con datos que no le pertenecen (le pide las horas y el valor al producto). Según la heurística del Experto, la responsabilidad de calcular el costo debe asignarse a la clase que posee la información para hacerlo: el propio producto.
4. **Falta de Cohesión / Problema de Identidad (Falla la prueba "es un"):** La clase `Producto` actúa como una "Clase Dios" que mezcla variables de dos entidades del dominio totalmente distintas (un Servicio y un Producto Físico). Esto se debe resolver creando una jerarquía de clases con una abstracción común.

### b) Implementación de la solución correcta

Para solucionarlo, extraemos una interfaz común (`ItemFacturable`) y creamos dos clases concretas (`Servicio` y `ProductoFisico`) que implementan su propio cálculo de costo polimórficamente.

```java
import java.util.List;
import java.util.ArrayList;

// 1. Abstracción común para aplicar polimorfismo
public interface ItemFacturable {
    public double calcularCosto();
}

// 2. Clase concreta para Servicio
public class Servicio implements ItemFacturable {
    private int horasTrabajadas;
    private double valorHora;
    private String objetivo;

    public Servicio(int horasTrabajadas, double valorHora, String objetivo) {
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.objetivo = objetivo;
    }

    @Override
    public double calcularCosto() {
        // El experto calcula su propio costo
        return this.horasTrabajadas * this.valorHora; 
    }
}

// 3. Clase concreta para Producto Físico
public class ProductoFisico implements ItemFacturable {
    private double costo;
    private double costoDeEnvioPorKilo;
    private double peso;
    private String nombre;

    public ProductoFisico(double costo, double costoDeEnvioPorKilo, double peso, String nombre) {
        this.costo = costo;
        this.costoDeEnvioPorKilo = costoDeEnvioPorKilo;
        this.peso = peso;
        this.nombre = nombre;
    }

    @Override
    public double calcularCosto() {
        return this.costo + (this.costoDeEnvioPorKilo * this.peso);
    }
}

// 4. Clase Pedido limpia y delegando responsabilidades
public class Pedido {
    private List<ItemFacturable> items;

    public Pedido() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemFacturable item) {
        this.items.add(item);
    }

    public double costoTotal() {
        // Se utiliza polimorfismo para obtener el costo de cada item
        return this.items.stream()
                   .mapToDouble(ItemFacturable::calcularCosto)
                   .sum();
    }
}
```

### Ejercicio 2. Tests

### a) Métodos a testear, particiones equivalentes y valores borde
Para diseñar los tests, aplicaremos las estrategias de particiones de equivalencia y valores de borde.

1. **Método `calcularCosto()` de la clase `Servicio`**
    * *Particiones equivalentes:* Servicios con horas trabajadas mayores a 0.
    * *Valores borde:* Horas trabajadas = 0 (límite inferior donde el costo es 0).
2. **Método `calcularCosto()` de la clase `ProductoFisico`**
    * *Particiones equivalentes:* Productos con peso y costos positivos.
    * *Valores borde:* Peso = 0 (límite que anula el costo de envío).
3. **Método `costoTotal()` de la clase `Pedido`**
    * *Particiones equivalentes:* Pedido con una lista vacía; Pedido con una lista con elementos.

### b) Tabla de casos a testear

| descripción del caso | metodo a testear | valores usados |
| :--- | :--- | :--- |
| **testCostoServicioEstandar** | `calcularCosto()` de `Servicio` | horasTrabajadas = 5, valorHora = 100 |
| **testCostoProductoEstandar** | `calcularCosto()` de `ProductoFisico` | costo = 500, costoDeEnvioPorKilo = 3, peso = 1 |
| **testCostoTotalPedidoVacio** | `costoTotal()` de `Pedido` | items = lista vacía |
| **testCostoTotalVariosItems** | `costoTotal()` de `Pedido` | items = [Servicio(5, 100), ProductoFisico(500, 3, 1)] |

### c) Implementación de los casos de prueba (JUnit 5)

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    private Servicio servicio;
    private ProductoFisico productoFisico;
    private Pedido pedidoVacio;
    private Pedido pedidoConItems;

    @BeforeEach
    void setUp() {
        // Inicialización (Fixture)
        servicio = new Servicio(5, 100, "Configurar la red Wi-Fi");
        productoFisico = new ProductoFisico(500, 3, 1, "Martillo");
        
        pedidoVacio = new Pedido();
        
        pedidoConItems = new Pedido();
        pedidoConItems.agregarItem(servicio);
        pedidoConItems.agregarItem(productoFisico);
    }

    @Test
    void testCostoServicioEstandar() {
        // Esperado: 5 horas * 100 = 500
        assertEquals(500.0, servicio.calcularCosto());
    }

    @Test
    void testCostoProductoEstandar() {
        // Esperado: 500 + (3 * 1) = 503
        assertEquals(503.0, productoFisico.calcularCosto());
    }

    @Test
    void testCostoTotalPedidoVacio() {
        // Borde: Colección vacía
        assertEquals(0.0, pedidoVacio.costoTotal());
    }

    @Test
    void testCostoTotalVariosItems() {
        // Esperado: 500 (del servicio) + 503 (del producto) = 1003
        assertEquals(1003.0, pedidoConItems.costoTotal());
    }
}
```