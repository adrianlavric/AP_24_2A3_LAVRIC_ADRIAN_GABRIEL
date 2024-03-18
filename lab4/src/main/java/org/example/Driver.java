package org.example;

public class Driver extends Person {
    Driver() {}
    public Driver(String name, int age, String destination) {
        super(name, age, destination);
    }

    @Override
    public String toString() {
        return "Driver: " + getName() + ", age: " + getAge() + ", destination: " + getDestination();
    }
}
