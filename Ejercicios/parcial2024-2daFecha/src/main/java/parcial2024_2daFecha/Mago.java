package parcial2024_2daFecha;

public class Mago implements Rol{
    @Override
    public double calcularValorBase(Habilidad h, int nivel) {
        return (h.getInteligencia() + nivel) * 2;
    }

    @Override
    // lo hace el rol ya que el decide que tipo de habilidad (fuerza o inteligencia) aumentar.
    public void incrementarHabilidad(Habilidad habilidad, int nivel) {
    	habilidad.aumentarInteligencia(3/2 * nivel);
    } 
}
