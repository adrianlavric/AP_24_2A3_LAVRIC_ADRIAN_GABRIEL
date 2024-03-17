package lab3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public class Trip {
    private String city;
    private LocalDate start;
    private LocalDate end;
    private List<Attraction> attractions;

    public Trip(String city, LocalDate start, LocalDate end) {
        this.city = city;
        this.start = start;
        this.end = end;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        StringBuilder tripToString = new StringBuilder();
        tripToString.append("Trip to ").append(city).append(" (").append(start).append(" to ").append(end).append(")\n");
        tripToString.append("Attractions:\n");
        for (Attraction attraction : attractions) {
            tripToString.append(attraction.getName()).append(": ").append(attraction.getDescription()).append("\n");
        }
        return tripToString.toString();
    }

}
