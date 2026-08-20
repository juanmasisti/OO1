### Resolución - Examen Final OO1 (Julio 2025)
1. Diagrama de Clases UML. 
 Se utiliza una clase abstracta *Dado* que define el comportamiento polimórfico **lanzar()**, de la cual heredan los distintos tipos de dados para evitar condicionales.Fragmento de códigoclassDiagram

    class Cubilete {
        - dados: List<Dado>
        + agregarDado(dado: Dado)
        + lanzar(): ResultadoLanzamiento
    }

    class ResultadoLanzamiento {
        - timestamp: LocalDateTime
        - valores: List<Integer>
        - total: int
        + getValores(): List<Integer>
        + getTimestamp(): LocalDateTime
        + getTotal(): int
    }

    class Dado {
        <<abstract>>
        + lanzar(): int
        + generarAleatorio(min: int, max: int): int
    }

    class DadoEstandar {
        + lanzar(): int
    }

    class DadoConModificador {
        - modificador: int
        + lanzar(): int
    }

    class DadoPonderado {
        - carasPonderadas: List<Integer>
        + lanzar(): int
    }

    class DadoExplosivo {
        + lanzar(): int
    }

    Cubilete "1" --> "*" Dado : contiene
    Cubilete ..> ResultadoLanzamiento : crea
    Dado <|-- DadoEstandar
    Dado <|-- DadoConModificador
    Dado <|-- DadoPonderado
    Dado <|-- DadoExplosivo

2. Implementación en Java.
A continuación se detalla la implementación, respetando el encapsulamiento (variables private) y el polimorfismo. Además, se garantiza que ResultadoLanzamiento sea inmutable copiando la lista de valores, cumpliendo así el requerimiento: "guardar el resultado del lanzamiento sin que posteriores lanzamientos del mismo cubilete lo afecten".

// 1. Objeto Inmutable para el resultado
public class ResultadoLanzamiento {
    private LocalDateTime timestamp;
    private List<Integer> valores;
    private int total;

    public ResultadoLanzamiento(List<Integer> valoresLanzamiento) {
        this.timestamp = LocalDateTime.now();
        // Hacemos una copia para evitar que se modifique desde afuera (Inmutabilidad)
        this.valores = new ArrayList<>(valoresLanzamiento);
        this.total = this.valores.stream().mapToInt(Integer::intValue).sum();
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public List<Integer> getValores() { return new ArrayList<>(valores); } // Retornamos copia
    public int getTotal() { return total; }
}

// 2. Abstracción base para los dados
public abstract class Dado {
    protected Random random = new Random();
    
    // Método polimórfico
    public abstract int lanzar();
    
    public int generarAleatorio(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}

// 3. Implementaciones concretas de Dados
public class DadoEstandar extends Dado {
    @Override
    public int lanzar() {
        return this.generarAleatorio(1, 6);
    }
}

public class DadoConModificador extends DadoEstandar {
    private int modificador;

    public DadoConModificador(int modificador) {
        this.modificador = modificador;
    }

    @Override
    public int lanzar() {
        return super.lanzar() + this.modificador;
    }
}

public class DadoPonderado extends Dado {
    private List<Integer> carasPonderadas;

    public DadoPonderado(List<Integer> carasPonderadas) {
        // Ej: [1, 2, 3, 4, 5, 6, 6, 6] (El 6 tiene más probabilidad)
        this.carasPonderadas = new ArrayList<>(carasPonderadas); 
    }

    @Override
    public int lanzar() {
        int index = this.generarAleatorio(0, this.carasPonderadas.size() - 1);
        return this.carasPonderadas.get(index);
    }
}

public class DadoExplosivo extends DadoEstandar {
    @Override
    public int lanzar() {
        int tirada = super.lanzar();
        if (tirada == 6) {
            return tirada + this.lanzar(); // Llamada recursiva si es explosivo
        }
        return tirada;
    }
}

// 4. El Cubilete
public class Cubilete {
    private List<Dado> dados;

    public Cubilete() {
        this.dados = new ArrayList<>();
    }

    public void agregarDado(Dado dado) {
        this.dados.add(dado);
    }

    public ResultadoLanzamiento lanzar() {
        List<Integer> valoresObtenidos = new ArrayList<>();
        for (Dado dado : this.dados) {
            valoresObtenidos.add(dado.lanzar());
        }
        // Crea y retorna el objeto inmutable
        return new ResultadoLanzamiento(valoresObtenidos);
    }
}

## 3. Casos de Prueba (Valores Borde y Particiones Equivalentes)

A continuación se listan los casos de prueba lógicos para validar el comportamiento del sistema, detallando los parámetros de inicialización y la técnica de testing aplicada (Particiones Equivalentes o Valores de Borde).

| Descripción del Caso | Método a testear | Parámetros utilizados | Origen (Borde / Partición) | Justificación de la elección |
| :--- | :--- | :--- | :--- | :--- |
| **testLanzamientoModificadorPositivo** | `lanzar()` de `DadoConModificador` | Modificador = `+2`. | **Partición Equivalente** | Representa el caso general de sumar un valor positivo. El resultado final debe estar desplazado en +2 respecto a un dado estándar. |
| **testLanzamientoModificadorNegativo** | `lanzar()` de `DadoConModificador` | Modificador = `-3`. | **Partición Equivalente** | Prueba el caso donde el modificador resta, validando que la suma aritmética funcione correctamente con negativos. |
| **testCubileteVacio** | `lanzar()` de `Cubilete` | Cubilete con `0` dados (Lista vacía). | **Valor de Borde** | Prueba el límite inferior de la colección. Debe retornar un `ResultadoLanzamiento` con `total = 0` y una lista de valores vacía sin lanzar excepciones. |
| **testCubileteConMultiplesDados** | `lanzar()` de `Cubilete` | Cubilete con `3` dados estándar. | **Partición Equivalente** | Representa el caso de uso normal del cubilete. Verifica que se itere sobre todos los dados y se acumulen correctamente los resultados. |
| **testInmutabilidadResultadoModificacionExterna** | `getValores()` de `ResultadoLanzamiento` | Lista de inicialización: `[3, 5, 2]`. | **Partición Equivalente** | Se obtiene la lista devuelta por el getter y se intenta modificar (ej. `remove()`). Se valida que la lista original dentro del objeto se mantenga intacta, asegurando la inmutabilidad. |
| **testResultadosIndependientes** | `lanzar()` de `Cubilete` | Cubilete con `1` dado estándar lanzado `2` veces. | **Partición Equivalente** | Se lanza el mismo cubilete dos veces consecutivas. Verifica que el segundo lanzamiento genere una nueva instancia de `ResultadoLanzamiento` y no pise los datos (timestamp/valores) del primero. |