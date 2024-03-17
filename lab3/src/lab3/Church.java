package lab3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public class Church extends Attraction implements Visitable {

    private Map<LocalDate, TimeInterval> timetable;

    public Church(String name, String description) {
        super(name, description);
        this.timetable = new HashMap<>();
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
}
