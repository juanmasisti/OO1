package ejercicio11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {

    private CuentaCorriente ccDescubierto;
    private CuentaCorriente ccSinDescubierto;

    @BeforeEach
    void setUp() {
        ccDescubierto = new CuentaCorriente(100);
        ccSinDescubierto = new CuentaCorriente();
    }

    // ---------- Depositar ----------
    @Test
    void depositarEnCC_sumaMontoCompleto() {
    	ccDescubierto.depositar(150.0);
        assertEquals(150.0, ccDescubierto.getSaldo(), 0.02);
    }


    // ---------- Extraer (CuentaCorriente) ----------
    
    @Test 
    void ccExtraer_soloConSaldo() {
    	ccSinDescubierto.depositar(200);
    	ccSinDescubierto.extraer(200);
    	assertEquals(0, ccSinDescubierto.getSaldo(), 0.02);
    }
    
    @Test
    void ccExtraer_permiteHastaDescubierto() {
        ccDescubierto.depositar(200);
    	boolean ok = ccDescubierto.extraer(300); // saldo 200, descubierto 100; 200-300 = -100
        assertTrue(ok);
        assertEquals(-100.0, ccDescubierto.getSaldo(), 0.01);
    }

    @Test
    void ccExtraer_superaDescubierto_devuelveFalse() {
        boolean ok = ccDescubierto.extraer(150.0); // intentaría -150, supera descubierto 100
        assertFalse(ok);
        assertEquals(0.0, ccDescubierto.getSaldo(), 0.01);
    }
    
    // ---------- Setters / invariantes ----------
    @Test
    void setDescubiertoNegativo_debeLanzar() {
        CuentaCorriente c = new CuentaCorriente();
        assertThrows(IllegalArgumentException.class, () -> c.setDescubierto(-10.0));
    }
}

