package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

public class Lab4 {
    public static void main(String[] args) {

        Lab4 lab4 = new Lab4();
        lab4.Compulsory();
        lab4.Homework();

    }

    public void Compulsory() {
        Random random = new Random();
        var persons = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> {
                    String name = "Person" + i;
                    int age = i + 10 + random.nextInt(50);
                    String destination = "Destination" + random.nextInt(10);
                    return random.nextBoolean() ? new Driver(name, age, destination) : new Passenger(name, age, destination);
                })
                .collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Passenger> passengers = persons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Drivers: ");
        drivers.stream()
                .sorted(Comparator.comparingInt(Driver::getAge))
                .forEach(System.out::println);

        System.out.println("Passengers:");
        passengers.stream()
                .sorted(Comparator.comparing(Passenger::getName))
                .forEach(System.out::println);
    }

    public void Homework() {
        CarSharing carSharing = new CarSharing(10, 10);
        System.out.println("all the destinations that the drivers pass through: " + carSharing.getAllDestinationsOfDrivers());
        System.out.println("map of destinations and people: " + carSharing.getDestinationsOfPassengers());
        carSharing.greedySolution();

    }

    public void Bonus() {



    }
}
