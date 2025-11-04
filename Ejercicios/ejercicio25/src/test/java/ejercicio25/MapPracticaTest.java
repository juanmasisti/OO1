package ejercicio25;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MapPracticaTest {

	@Test
	void testMapGolesJugadores() {
	    Map<String, Integer> goles = new HashMap<>();

	    // Agregar entradas
	    goles.put("Lionel Messi", 111);
	    goles.put("Gabriel Batistuta", 56);
	    goles.put("Kun Agüero", 42);

	    // Eliminar al Kun
	    goles.remove("Kun Agüero");
	    assertFalse(goles.containsKey("Kun Agüero"));

	    // Actualizar Messi
	    goles.put("Lionel Messi", 112);
	    assertEquals(112, goles.get("Lionel Messi"));

	    // Intentar duplicar Batistuta (reemplaza)
	    goles.put("Gabriel Batistuta", 60);
	    assertEquals(60, goles.get("Gabriel Batistuta"));

	    // Total de goles
	    int total = goles.values().stream().mapToInt(Integer::intValue).sum();
	    assertEquals(172, total);
	}
}


