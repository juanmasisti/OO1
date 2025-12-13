package parcial2024_2daFecha;

public class Guerrero implements Rol{
    @Override
    public double calcularValorBase(Habilidad h, int nivel) {
        return (h.getFuerza() * 2) + nivel + h.getInteligencia();
    }

    @Override
    // lo hace el rol ya que el decide que tipo de habilidad (fuerza o inteligencia) aumentar.
    public void incrementarHabilidad(Habilidad habilidad, int nivel) {
    	habilidad.aumentarFuerza(nivel/6);
    } 
}
