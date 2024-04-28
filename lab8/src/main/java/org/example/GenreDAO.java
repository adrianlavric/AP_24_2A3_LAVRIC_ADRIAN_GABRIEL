package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenreDAO {
    public void create(String genre) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into genres (genre) values (?)")) {
            pstmt.setString(1, genre);
            pstmt.executeUpdate();
        }
    }
}
