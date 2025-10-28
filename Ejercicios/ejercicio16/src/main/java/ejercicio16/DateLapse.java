package ejercicio16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ejercicio17.IDateLapse;

public class DateLapse implements IDateLapse{
	private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public int sizeInDays() {
        return (int) ChronoUnit.DAYS.between(from, to);
    }

    public boolean includesDate(LocalDate other) {
        // “recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.
        return (other.equals(from) || other.equals(to)
                || (other.isAfter(from) && other.isBefore(to)));
    }
    
    /**
    Retorna true si el período de tiempo del receptor se superpone con el recibido por parámetro
    **/

    public boolean overlaps(DateLapse another) {
        return !(this.to.isBefore(another.from) || this.from.isAfter(another.to));
    }
}

//Crear una fecha determinada
//LocalDate fecha = LocalDate.of(1972, 9, 15);

//Determinar si la fecha de hoy está entre dos fechas dadas
//Usa los métodos de comparación de LocalDate

//Calcular el número de días, meses y años entre dos fechas (para hacer cast usar (int))
// Días
	//long dias = ChronoUnit.DAYS.between(inicio, fin);
//Meses
	//long meses = ChronoUnit.MONTHS.between(inicio, fin);
//Años
	//long años = ChronoUnit.YEARS.between(inicio, fin);

//Usando el método until()
	//long dias = inicio.until(fin, ChronoUnit.DAYS);
