package ejercicio11;

//CajaDeAhorro.java
public class CajaDeAhorro extends Cuenta {
 private static final double COSTO_PORC = 0.02;

 public CajaDeAhorro() {
     super();
 }

 public CajaDeAhorro(double saldoInicial) {
     super();
     this.saldo = saldoInicial;
 }

 @Override
 public void depositar(double monto) {
     // Depósito con costo del 2% (el banco se queda 2% del monto)
     double neto = monto * (1 - COSTO_PORC);
     super.depositar(neto);
 }

 @Override
 protected void extraerSinControlar(double monto) {
     // Al extraer, se descuenta el monto + 2% de costo
     double costoTotal = monto * (1 + COSTO_PORC);
     this.saldo -= costoTotal;
 }

 @Override
 protected boolean puedeExtraer(double monto) {
     // Se permite sólo si hay fondos para cubrir monto + 2%
     double costoTotal = monto * (1 + COSTO_PORC);
     return this.saldo >= costoTotal;
 }
}
