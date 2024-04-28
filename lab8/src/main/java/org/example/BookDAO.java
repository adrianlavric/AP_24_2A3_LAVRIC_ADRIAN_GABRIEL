package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAO {
    public void create(int publicationYear, String title, String authorName, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO books (publication_year, title, author_id, genre_id) " +
                        "VALUES (?, ?, (SELECT author_id FROM authors WHERE name = ? LIMIT 1), " +
                        "(SELECT genre_id FROM genres WHERE genre = ? LIMIT 1))")) {
            pstmt.setInt(1, publicationYear);
            pstmt.setString(2, title);
            pstmt.setString(3, authorName);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }

    public void printAllBooks() throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT b.publication_year, b.title, a.name AS author, g.genre " +
                     "FROM books b " +
                     "JOIN authors a ON b.author_id = a.author_id " +
                     "JOIN genres g ON b.genre_id = g.genre_id")) {
            while (rs.next()) {
                int publicationYear = rs.getInt("publication_year");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                System.out.println(publicationYear + ", " + title + ", " + author + ", " + genre);
            }
        }
    }

}
