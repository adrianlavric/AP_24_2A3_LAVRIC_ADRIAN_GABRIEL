package lab2;

/**
 *
 * @author Lavric Adrian-Gabriel
 */

import java.time.LocalTime;
public class Lab2 {
    public static void main(String[] args) {

        Lab2 lab2 = new Lab2();
        lab2.Compulsory();



    }

    public void Compulsory() {

//        Vehicle car1 = new Vehicle("BMW");
//        Vehicle car2 = new Vehicle();
//        car2.setName("Audi");

        Client client1 = new Client();
        client1.setMinTime(LocalTime.of(9, 0));
        client1.setMaxTime(LocalTime.of(17,0));
        client1.setName("Andrei");
        client1.setType(Type.PREMIUM);

        Client client2 = new Client(Type.REGULAR, "George", LocalTime.of(8, 0), LocalTime.of(15, 0));

        Client client3 = new Client("Vasile");

        Depot depot1 = new Depot("Depot 1");
        Depot depot2 = new Depot();
        depot2.setName("Depot 2");

//        depot1.setVehicles(car1);
//        depot2.setVehicles(car2);

        System.out.println(depot1);
//        System.out.println(car1);
//        System.out.println(car2);
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);

    }

    public void Homework() {

        Problem pb = new Problem();


    }

}