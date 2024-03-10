package lab2;

import java.time.LocalTime;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

enum Type {
    REGULAR,
    PREMIUM
}

public class Client {

    private Type type;
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;

    public Client() { }
    public Client(String name) {
        this(name, null, null);
    }
    public Client(String name, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }
    public Client(Type type, String name, LocalTime minTime, LocalTime maxTime) {
        this.type = type;
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalTime getMinTime() {
        return minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    @Override
    public String toString() {

        return "Client: " + getType() + ", name: " + getName() + ", visiting interval: " + getMinTime() + " - " + getMaxTime() + ".";

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Client)) {
            return false;
        }
        Client other = (Client) obj;
        return name.equals(other.name) && minTime.equals(other.minTime) && maxTime.equals(other.maxTime) && type.equals(other.type);
    }
}
