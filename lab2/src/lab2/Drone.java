package lab2;

import java.time.Duration;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public class Drone extends Vehicle{
    Duration maxFlightDuration;

    public Drone(String name, Duration duration) {
        super(name);
        maxFlightDuration = duration;
    }

    public Duration getMaxFlightDuration() {
        return maxFlightDuration;
    }

    public void setMaxFlightDuration(Duration maxFlightDuration) {
        this.maxFlightDuration = maxFlightDuration;
    }

    @Override
    public String toString() {
        return super.toString() + ", maximum flight duration: " + maxFlightDuration;
    }
}
