package ejercicio11;

//CuentaTest.java (JUnit 5)
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

 private static final double EPS = 1e-6;

 @Test
 void cajaDepositeConCosto() {
     CajaDeAhorro caja = new CajaDeAhorro();
     caja.depositar(100.0); // costo 2% -> neto 98
     assertEquals(98.0, caja.getSaldo(), EPS);
 }

 @Test
 void cajaExtraeInsuficientePorCosto() {
     CajaDeAhorro caja = new CajaDeAhorro(100.0);
     boolean ok = caja.extraer(100.0); // necesita 102 -> no puede
     assertFalse(ok);
     assertEquals(100.0, caja.getSaldo(), EPS);
 }

 @Test
 void cajaExtraeSuficienteConCosto() {
     CajaDeAhorro caja = new CajaDeAhorro(200.0);
     boolean ok = caja.extraer(100.0); // descontará 102 -> queda 98
     assertTrue(ok);
     assertEquals(98.0, caja.getSaldo(), EPS);
 }

 @Test
 void transferCajaACuentaCorriente() {
     CajaDeAhorro origen = new CajaDeAhorro(200.0);
     CuentaCorriente destino = new CuentaCorriente();
     boolean ok = origen.transferirACuenta(100.0, destino);
     // origen: -102 => 98, destino: depositar 100 (sin costo en CC)
     assertTrue(ok);
     assertEquals(98.0, origen.getSaldo(), EPS);
     assertEquals(100.0, destino.getSaldo(), EPS);
 }

 @Test
 void transferCajaACaja() {
     CajaDeAhorro origen = new CajaDeAhorro(200.0);
     CajaDeAhorro destino = new CajaDeAhorro(0.0);
     boolean ok = origen.transferirACuenta(100.0, destino);
     // origen: -102 => 98
     // destino.depositar(100) => neto 98 (porque destino también aplica 2% en depositar)
     assertTrue(ok);
     assertEquals(98.0, origen.getSaldo(), EPS);
     assertEquals(98.0, destino.getSaldo(), EPS);
 }

 @Test
 void cuentaCorrientePermiteDescubierto() {
     CuentaCorriente cc = new CuentaCorriente(500.0); // descubierto = 500
     boolean ok1 = cc.extraer(400.0);
     assertTrue(ok1);
     assertEquals(-400.0, cc.getSaldo(), EPS);

     // ahora intentar extraer 200 más -> quedaría -600, supera descubierto
     boolean ok2 = cc.extraer(200.0);
     assertFalse(ok2);
     assertEquals(-400.0, cc.getSaldo(), EPS);
 }

 @Test
 void transferirDesdeCuentaCorrienteAAhorro() {
     CuentaCorriente cc = new CuentaCorriente(500.0);
     CajaDeAhorro caja = new CajaDeAhorro(0.0);
     boolean ok = cc.transferirACuenta(300.0, caja);
     // cc: -300; caja.depositar(300) -> neto 294 (2% fee)
     assertTrue(ok);
     assertEquals(-300.0, cc.getSaldo(), EPS);
     assertEquals(294.0, caja.getSaldo(), EPS);
 }
}
