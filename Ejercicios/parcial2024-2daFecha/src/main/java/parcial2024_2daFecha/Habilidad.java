package parcial2024_2daFecha;

public class Habilidad {

    private int inteligencia;
    private int fuerza;


    public Habilidad(int inteligencia, int fuerza) {
        this.inteligencia = inteligencia;
        this.fuerza = fuerza;
    }

    public void aumentarFuerza(int incremento) {
        this.fuerza += incremento;
    }

    public void aumentarInteligencia(int incremento) {
        this.inteligencia += incremento;
    }

	public int getFuerza() {
		return fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

    
}
