package lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();

    default LocalTime getOpeningHour(LocalDate date) {
        Map<LocalDate, TimeInterval> timetable = getTimetable();
        TimeInterval interval = timetable.get(date);
        if (interval != null) {
            return interval.getFirst();
        }
        return null;
    }
}