package ejercicio25;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MapJugadorTest {

	@Test
	void testMapConObjetosJugador() {
	    Map<Jugador, Integer> goles = new HashMap<>();

	    Jugador messi = new Jugador("Lionel", "Messi");
	    Jugador bati = new Jugador("Gabriel", "Batistuta");
	    Jugador kun = new Jugador("Sergio", "Agüero");

	    goles.put(messi, 111);
	    goles.put(bati, 56);
	    goles.put(kun, 42);

	    goles.remove(kun);
	    goles.put(messi, 112); // Actualización
	    goles.put(bati, 60);   // Reemplazo permitido

	    int total = goles.values().stream().mapToInt(Integer::intValue).sum();
	    assertEquals(172, total);
	}

}
