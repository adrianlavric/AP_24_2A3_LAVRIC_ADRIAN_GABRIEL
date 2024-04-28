package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //Compulsory();
        Homework();
    }

    public static void Compulsory() {
        try {
            var authors1 = new AuthorDAO();
            authors1.create("Mihai Eminescu");
            var authors2 = new AuthorDAO();
            authors2.create("Ion Creanga");
            var genres1 = new GenreDAO();
            genres1.create("Dramatic");
            var genres2 = new GenreDAO();
            genres2.create("Comedie");

            Database.getConnection().commit();

            var books = new BookDAO();
            books.create(1880, "Luceafarul", "Mihai Eminescu", "Dramatic");
            books.create(1860, "Povestea lui Harap-Alb", "Ion Creanga", "Comedie");
            Database.getConnection().commit();

            books.printAllBooks();

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

    public static void Homework() {
        DataImporter dataImporter = new DataImporter();
        String filePath = "C:\\Users\\adria\\OneDrive\\Desktop\\AP_24_2A3_LAVRIC_ADRIAN_GABRIEL\\lab8\\src\\main\\resources\\books.csv";
        dataImporter.importData(filePath);
    }
}
