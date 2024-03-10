package lab2;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public abstract class Vehicle {

    protected String name;
    protected Depot depot;

    public Vehicle() {}
    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    @Override
    public String toString() {

        return "Vehicle: " + getName() + ", depot: " + getDepot();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }
}
