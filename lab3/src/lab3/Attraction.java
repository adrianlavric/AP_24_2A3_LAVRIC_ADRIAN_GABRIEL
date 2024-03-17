package lab3;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public abstract class Attraction implements Comparable<Attraction> {
    private String name;
    private String description;

    public Attraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", description: " + description;
    }

    @Override
    public int compareTo(Attraction other) {
        if(this.name != null && other.name != null) return this.name.compareTo(other.name);
        return 0;
    }

}
