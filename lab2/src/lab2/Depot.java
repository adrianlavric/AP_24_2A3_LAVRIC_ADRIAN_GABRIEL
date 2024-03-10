package lab2;

import java.util.Arrays;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public class Depot {

    private String name;
    private Vehicle[] vehicles;

    public Depot() {}
    public Depot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicles(Vehicle ... vehicles) {
        this.vehicles = vehicles;
        for(Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        return "Depot: " + getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) obj;
        return name.equals(other.name) && Arrays.equals(vehicles, other.vehicles);
    }

}
