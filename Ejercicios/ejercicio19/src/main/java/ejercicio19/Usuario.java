package ejercicio19;

import java.util.ArrayList;
import java.util.List;

import ejercicio16.DateLapse;

public class Usuario {
    private String nombre;
    private String direccion;
    private String dni;
    private List<Propiedad> propiedades;
    private List<Reserva> reservas;

    public Usuario(String nombre, String direccion, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.propiedades = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public List<Propiedad> getPropiedades(){
    	return this.propiedades;
    }
    
    public List<Reserva> getReservas(){
    	return this.reservas;
    }
    public void agregarPropiedad(Propiedad p) {
        propiedades.add(p);
    }

    public Reserva reservar(Propiedad propiedad, DateLapse periodo) {
        if (propiedad.estaDisponible(periodo)) {
            Reserva reserva = new Reserva(periodo, propiedad);
            propiedad.agregarReserva(reserva);
            reservas.add(reserva);
            return reserva;
        }
        return null;
    }

    public double calcularIngresos(DateLapse periodo) {
        return propiedades.stream()
                .mapToDouble(p -> p.calcularIngresos(periodo))
                .sum();
    }
}
