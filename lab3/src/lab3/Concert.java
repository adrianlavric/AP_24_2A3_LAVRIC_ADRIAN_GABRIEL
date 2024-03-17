package lab3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public class Concert extends Attraction implements Payable, Visitable {
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;

    public Concert(String name, String description, double ticketPrice) {
        super(name, description);
        this.ticketPrice = ticketPrice;
        timetable = new HashMap<>();
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

}
