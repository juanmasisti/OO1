package ejercicio25;

import java.util.Objects;

public class Jugador {
    private String nombre;
    private String apellido;

    public Jugador(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;
        Jugador j = (Jugador) o;
        return nombre.equals(j.nombre) && apellido.equals(j.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
