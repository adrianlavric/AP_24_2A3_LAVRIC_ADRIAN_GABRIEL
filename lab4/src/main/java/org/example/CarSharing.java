package org.example;

import com.github.javafaker.Faker;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class CarSharing {

    private List<Driver> drivers;
    private List<Passenger> passengers;

    CarSharing(int numberOfDrivers, int numberOfPassengers) {
        Faker faker = new Faker();
        drivers = generateRandomDrivers(numberOfDrivers, faker);
        passengers = generateRandomPassengers(numberOfPassengers, faker);

    }

    private List<Driver> generateRandomDrivers(int count, Faker faker) {
        List<Driver> randomDrivers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = faker.name().fullName();
            int age = faker.number().numberBetween(16, 70);
            String destination = faker.address().city();
            randomDrivers.add(new Driver(name, age, destination));
        }
        return randomDrivers;
    }

    private List<Passenger> generateRandomPassengers(int count, Faker faker) {
        List<Passenger> randomPassengers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = faker.name().fullName();
            int age = faker.number().numberBetween(16, 70);
            String destination = faker.address().city();
            randomPassengers.add(new Passenger(name, age, destination));
        }
        return randomPassengers;
    }

    public List<String> getAllDestinationsOfDrivers() {
        return drivers.stream()
                .map(Person::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, List<Person>> getDestinationsOfPassengers() {
        return passengers.stream()
                .collect(Collectors.groupingBy(Person::getDestination, Collectors.toList()));
    }

    public void greedySolution() {
        Map<Driver, Passenger> pair = new HashMap<>();
        for (Driver driver : drivers) {
            List<Passenger> potentialPassengers = passengers.stream()
                    .filter(passenger -> passenger.getDestination().equals(driver.getDestination()))
                    .collect(Collectors.toList());
            if (!potentialPassengers.isEmpty()) {
                Passenger passenger = potentialPassengers.get(0);
                pair.put(driver, passenger);
                passengers.remove(passenger);
            }
        }

        if (pair.isEmpty()) {
            System.out.println("There is no solution.");
        } else {
            System.out.println("Solutia greedy: ");
            pair.forEach((driver, passenger) ->
                    System.out.println("Driver: " + driver.getName() + ", passenger: " + passenger.getName() + driver.getDestination()));

        }
    }
}
