package ejercicio11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTests {
	private static final double COSTO_PORC = 0.02;

    private CajaDeAhorro caja;

    void setUp() {
        caja = new CajaDeAhorro();
    }

    // ---------- Depositar ----------
    @Test
    void depositarEnCaja_sumaMontoCompleto() {
    	caja.depositar(150.0);
        assertEquals(150.0, caja.getSaldo(), 0.02);
    }


    // ---------- Extraer (CuentaCorriente) ----------
    @Test 
    void cajaExtraer_permite() {
    	caja.depositar(250);
    	boolean ok = caja.extraer(200);
    	assertTrue(ok);
    	assertEquals((50-(200*COSTO_PORC)), caja.getSaldo(), 0.02);
    }
    
    @Test
    void ccExtraer_noPermite() {
    	caja.depositar(250);
    	boolean ok = caja.extraer(250);
    	assertTrue(ok);
    	assertEquals(0, caja.getSaldo(), 0.02);
    	
    }

    @Test
    void ccExtraer_superaDescubierto_devuelveFalse() {
        boolean ok = caja.extraer(150.0); // intentaría -150, supera descubierto 100
        assertFalse(ok);
    }
    
}
