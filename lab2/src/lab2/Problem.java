package lab2;

import java.util.ArrayList;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public class Problem {
    private Depot[] depots;
    private Client[] clients;
    private Vehicle[] vehicles;

    Problem() {}

    public Problem(Depot[] depots, Client[] clients, Vehicle[] vehicles) {

        for(int i = 0; i < depots.length - 1; i++) {
            for (int j = i + 1; j < depots.length; j++) {
                if (depots[i].equals(depots[j])) throw new IllegalArgumentException("Duplicate depot.");
            }
        }

        for(int i = 0; i < clients.length - 1; i++) {
            for (int j = i + 1; j < clients.length; j++) {
                if (clients[i].equals(clients[j])) throw new IllegalArgumentException("Duplicate client.");
            }
        }

        for(int i = 0; i < vehicles.length - 1; i++) {
            for (int j = i + 1; j < vehicles.length; j++) {
                if (vehicles[i].equals(vehicles[j])) throw new IllegalArgumentException("Duplicate vehicle.");
            }
        }

        this.depots = depots;
        this.clients = clients;
        this.vehicles = vehicles;

    }

    public Vehicle[] getVehicles() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        for(Depot d : depots) {
            Vehicle[] vehiclesInThisDepot = d.getVehicles();
            for(Vehicle v : vehiclesInThisDepot) {
                allVehicles.add(v);
            }
        }
        return allVehicles.toArray(new Vehicle[0]);
    }

}
