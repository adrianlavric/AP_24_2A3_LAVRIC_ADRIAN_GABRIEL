package lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {
    private Trip trip;
    private Map<Attraction, LocalDate> sortedAttractions;

    public TravelPlan(Trip trip) {
        this.trip = trip;
        sortedAttractions = new HashMap<>();
        LocalDate currentDate = trip.getStart();
        while (!currentDate.isAfter(trip.getEnd())) {
            for (Attraction attraction : trip.getAttractions()) {
                if (attraction instanceof Visitable) {
                    Visitable visitableAttraction = (Visitable) attraction;
                    LocalTime openingHour = visitableAttraction.getOpeningHour(currentDate);
                    if (openingHour != null) {
                        if (!openingHour.isAfter(LocalTime.now())) { // Check if the attraction is already open
                            sortedAttractions.put(attraction, currentDate);
                        }
                    }
                }
            }
            currentDate = currentDate.plusDays(1);
        }
    }

    public Map<Attraction, LocalDate> getSortedAttractions() {
        return sortedAttractions;
    }

    @Override
    public String toString() {
        StringBuilder travelPlan = new StringBuilder();
        travelPlan.append("Travel Plan:\n");
        for (Map.Entry<Attraction, LocalDate> entry : sortedAttractions.entrySet()) {
            travelPlan.append(entry.getKey().getName()).append(" - ").append(entry.getValue()).append("\n");
        }
        return travelPlan.toString();
    }
}
