package ejercicio11;

//CuentaCorriente.java
public class CuentaCorriente extends Cuenta {
 private double descubierto; // máximo saldo negativo permitido (>= 0)

 public CuentaCorriente() {
     super();
     this.descubierto = 0;
 }

 public CuentaCorriente(double descubiertoInicial) {
     super();
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
     // Se permite extraer siempre que no supere el límite de descubierto
     return (this.saldo - monto) >= -this.descubierto;
 }

 // extraerSinControlar heredado: resta exactamente 'monto' del saldo
}
