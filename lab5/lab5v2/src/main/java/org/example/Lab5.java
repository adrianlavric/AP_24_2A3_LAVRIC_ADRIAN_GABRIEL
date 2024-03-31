package org.example;

import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command:");
            String inputCommand = scanner.nextLine().trim();
            List<String> arguments = new ArrayList<>(Arrays.asList(inputCommand.split(" ")));

            if (arguments.size() == 0) {
                System.err.println("Error: Empty command.");
                continue;
            }

            String commandType = arguments.get(0).trim();

            if (commandType.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            try {
                Command command = createCommand(commandType);
                if (command != null) {
                    arguments.remove(0);
                    command.execute(arguments);
                } else {
                    System.out.println("Invalid command.");
                }
            } catch (CommandException e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
        }

    }

    public static Command createCommand(String command) {
        switch (command) {
            case "view":
                return new ViewCommand();
            case "report":
                return new ReportCommand();
            case "export":
                return new ExportCommand();
            default:
                return null;
        }
    }
}