package ejercicio11;

public class CuentaCorriente extends Cuenta {
 private double descubierto; // máximo saldo negativo permitido (>= 0)

 public CuentaCorriente() {
     super();
     this.descubierto = 0;
 }

 public CuentaCorriente(double saldoInicial, double descubiertoInicial) {
     super(saldoInicial);
     this.descubierto = descubiertoInicial;
 }

 public double getDescubierto() {
     return descubierto;
 }

 public void setDescubierto(double descubierto) {
     this.descubierto = descubierto;
 }

 @Override
 protected boolean puedeExtraer(double monto) {
     return (this.getSaldo() - monto) + this.descubierto >= 0;
 }
}
