package lab3;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        lab3.Compulsory();
        lab3.Homework();
    }

    public void Compulsory() {
        Trip trip = new Trip("Iasi", LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 8));

        Statue statue1 = new Statue("Statue", "statue");
        Church church1 = new Church("Church", "church");
        Concert concert1 = new Concert("Concert", "concert", 100.0);

        Map<LocalDate, TimeInterval> churchTimetable = new HashMap<>();
        churchTimetable.put(LocalDate.of(2024, 7, 1), new TimeInterval(LocalTime.of(6, 0), LocalTime.of(8, 0)));
        church1.setTimetable(churchTimetable);

        Map<LocalDate, TimeInterval> concertTimetable = new HashMap<>();
        concertTimetable.put(LocalDate.of(2024, 7, 6), new TimeInterval(LocalTime.of(20, 0), LocalTime.of(22, 0)));
        concert1.setTimetable(concertTimetable);

        trip.addAttraction(statue1);
        trip.addAttraction(church1);
        trip.addAttraction(concert1);

        System.out.println("Compulsory: ");
        System.out.println(trip);
        System.out.println(church1.getTimetable());
        System.out.println(concert1.getTicketPrice());
    }

    public void Homework() {
        Trip trip = new Trip("Iasi", LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 8));

        Statue statue1 = new Statue("Statue", "statue");
        Church church1 = new Church("Church", "church");
        Concert concert1 = new Concert("Concert", "concert", 100.0);

        Map<LocalDate, TimeInterval> churchTimetable = new HashMap<>();
        churchTimetable.put(LocalDate.of(2024, 7, 1), new TimeInterval(LocalTime.of(6, 0), LocalTime.of(8, 0)));
        church1.setTimetable(churchTimetable);

        Map<LocalDate, TimeInterval> concertTimetable = new HashMap<>();
        concertTimetable.put(LocalDate.of(2024, 7, 2), new TimeInterval(LocalTime.of(7, 0), LocalTime.of(22, 0)));
        concert1.setTimetable(concertTimetable);

        trip.addAttraction(statue1);
        trip.addAttraction(church1);
        trip.addAttraction(concert1);

        TravelPlan travelPlan = new TravelPlan(trip);

        System.out.println("Homework: ");
        System.out.println(travelPlan);

    }
}
