package ejercicio11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTests {
    private static final double EPS = 1e-6;

    private CajaDeAhorro caja;
    private CuentaCorriente cc;

    @BeforeEach
    void setUp() {
        caja = new CajaDeAhorro();
        cc = new CuentaCorriente();
    }

    // ---------- Constructores / getters ----------
    @Test
    void constructorCaja_inicializaSaldo() {
        CajaDeAhorro c = new CajaDeAhorro(500.0);
        assertEquals(500.0, c.getSaldo(), EPS);
    }

    @Test
    void constructorCC_inicializaSaldoYDescubierto() {
        CuentaCorriente c = new CuentaCorriente(100.0, 300.0);
        assertEquals(100.0, c.getSaldo(), EPS);
        assertEquals(300.0, c.getDescubierto(), EPS);
    }

    // ---------- Depositar ----------
    @Test
    void depositarEnCaja_aplicaComision() {
        caja.depositar(100.0); // neto 98
        assertEquals(100.0 * (1 - 0.02), caja.getSaldo(), EPS);
    }

    @Test
    void depositarEnCC_sumaMontoCompleto() {
        cc.depositar(150.0);
        assertEquals(150.0, cc.getSaldo(), EPS);
    }

    @Test
    void depositarMontoNegativo_debeLanzar() {
        assertThrows(IllegalArgumentException.class, () -> caja.depositar(-10.0));
    }

    // ---------- Extraer (Caja) ----------
    @Test
    void cajaExtraer_SaldoInsuficiente_devuelveFalse() {
        CajaDeAhorro c = new CajaDeAhorro(100.0);
        boolean ok = c.extraer(100.0); // necesita 102
        assertFalse(ok);
        assertEquals(100.0, c.getSaldo(), EPS);
    }

    @Test
    void cajaExtraer_SaldoExacto_devuelveTrue_ySaldoCero() {
        CajaDeAhorro c = new CajaDeAhorro(102.0);
        boolean ok = c.extraer(100.0); // cuesta 102
        assertTrue(ok);
        assertEquals(0.0, c.getSaldo(), EPS);
    }

    // ---------- Extraer (CuentaCorriente) ----------
    @Test
    void ccExtraer_permiteHastaDescubierto() {
        CuentaCorriente c = new CuentaCorriente(50.0, 200.0);
        boolean ok = c.extraer(200.0); // saldo 50 - 200 = -150
        assertTrue(ok);
        assertEquals(-150.0, c.getSaldo(), EPS);
    }

    @Test
    void ccExtraer_superaDescubierto_devuelveFalse() {
        CuentaCorriente c = new CuentaCorriente(0.0, 100.0);
        boolean ok = c.extraer(150.0); // intentaría -150, supera descubierto 100
        assertFalse(ok);
        assertEquals(0.0, c.getSaldo(), EPS);
    }

    // ---------- Transferencias ----------
    @Test
    void transfer_CajaToCC_aplicaComisionSoloEnOrigen() {
        CajaDeAhorro origen = new CajaDeAhorro(200.0);
        CuentaCorriente destino = new CuentaCorriente(0.0, 0.0);
        boolean ok = origen.transferirACuenta(100.0, destino);
        assertTrue(ok);
        // origen: descontó 100 * 1.02 = 102 -> 98
        assertEquals(98.0, origen.getSaldo(), EPS);
        // destino: depositó 100 entero
        assertEquals(100.0, destino.getSaldo(), EPS);
    }

    @Test
    void transfer_CCToCaja_aplicaComisionEnDestino() {
        CuentaCorriente origen = new CuentaCorriente(300.0, 100.0);
        CajaDeAhorro destino = new CajaDeAhorro(0.0);
        boolean ok = origen.transferirACuenta(200.0, destino);
        assertTrue(ok);
        // origen: 300 - 200 = 100
        assertEquals(100.0, origen.getSaldo(), EPS);
        // destino: recibe 200 pero aplica 2% -> 196
        assertEquals(200.0 * (1 - 0.02), destino.getSaldo(), EPS);
    }

    @Test
    void transfer_CajaToCaja_dobleComision() {
        CajaDeAhorro a = new CajaDeAhorro(300.0);
        CajaDeAhorro b = new CajaDeAhorro(0.0);
        boolean ok = a.transferirACuenta(100.0, b);
        assertTrue(ok);
        // origen: 300 - (100*1.02) = 198
        assertEquals(198.0, a.getSaldo(), EPS);
        // destino: depositar 100 => 98
        assertEquals(98.0, b.getSaldo(), EPS);
    }

    @Test
    void transfer_Insuficiente_noCambiaSaldos() {
        CajaDeAhorro a = new CajaDeAhorro(50.0);
        CuentaCorriente b = new CuentaCorriente(0.0, 0.0);
        boolean ok = a.transferirACuenta(50.0, b); // necesita 51
        assertFalse(ok);
        assertEquals(50.0, a.getSaldo(), EPS);
        assertEquals(0.0, b.getSaldo(), EPS);
    }

    // ---------- Setters / invariantes ----------
    @Test
    void setDescubiertoNegativo_debeLanzar() {
        CuentaCorriente c = new CuentaCorriente();
        assertThrows(IllegalArgumentException.class, () -> c.setDescubierto(-10.0));
    }
}
