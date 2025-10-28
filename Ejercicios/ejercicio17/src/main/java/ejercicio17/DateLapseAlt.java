package ejercicio17;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseAlt implements IDateLapse {

    private LocalDate from;
    private int sizeInDays;

    public DateLapseAlt(LocalDate from, int sizeInDays) {
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    @Override
    public LocalDate getFrom() {
        return from;
    }

    @Override
    public LocalDate getTo() {
        return from.plusDays(sizeInDays);
    }

    @Override
    public int sizeInDays() {
        return sizeInDays;
    }

    @Override
    public boolean includesDate(LocalDate other) {
        return (other.equals(from) || other.equals(this.getTo())
                || (other.isAfter(from) && other.isBefore(this.getTo())));
    }
}
