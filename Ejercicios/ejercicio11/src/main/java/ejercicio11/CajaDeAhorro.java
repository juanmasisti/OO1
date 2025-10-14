package ejercicio11;

public class CajaDeAhorro extends Cuenta {
 private static final double COSTO_PORC = 0.02;

 public CajaDeAhorro() {
     super();
 }

 @Override
 public void depositar(double monto) {
     super.depositar(monto - (monto * COSTO_PORC));
 }

 @Override
 protected void extraerSinControlar(double monto) {
     double costoTotal = monto + (monto * COSTO_PORC);
     super.extraerSinControlar(costoTotal);
 }

 @Override
 protected boolean puedeExtraer(double monto) {
     // Devuelve true si el saldo es mayor o igual al monto sumado el 2%
     double costoTotal = monto + (monto * COSTO_PORC);
     return this.getSaldo() >= costoTotal;
 }
}
