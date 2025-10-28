package ejercicio16;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DateLapseTest {

	@Test
	void testSizeInDays() {
	    DateLapse lapso = new DateLapse(LocalDate.of(2025,1,1), LocalDate.of(2025,1,11));
	    assertEquals(10, lapso.sizeInDays());
	}

	@Test
	void testSizeInDaysMismoDia() {
	    DateLapse lapso = new DateLapse(LocalDate.of(2025,1,1), LocalDate.of(2025,1,1));
	    assertEquals(0, lapso.sizeInDays());
	}
	
	@Test
	void testIncludesDateDentroDelLapso() {
	    DateLapse lapso = new DateLapse(LocalDate.of(2025,1,1), LocalDate.of(2025,1,10));
	    assertTrue(lapso.includesDate(LocalDate.of(2025,1,5)));
	}

	@Test
	void testIncludesDateEnElBorde() {
	    DateLapse lapso = new DateLapse(LocalDate.of(2025,1,1), LocalDate.of(2025,1,10));
	    assertTrue(lapso.includesDate(LocalDate.of(2025,1,1))); // igual a from
	    assertTrue(lapso.includesDate(LocalDate.of(2025,1,10))); // igual a to
	}

	@Test
	void testIncludesDateFueraDelLapso() {
	    DateLapse lapso = new DateLapse(LocalDate.of(2025,1,1), LocalDate.of(2025,1,10));
	    assertFalse(lapso.includesDate(LocalDate.of(2024,12,31))); // antes
	    assertFalse(lapso.includesDate(LocalDate.of(2025,1,11))); // después
	}

}
