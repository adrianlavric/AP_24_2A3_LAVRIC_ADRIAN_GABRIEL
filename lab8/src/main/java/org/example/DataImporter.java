package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataImporter {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

    public void importData(String filePath) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             Connection connection = ConnectionPool.getConnection()) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    int bookID = Integer.parseInt(parts[0].replaceAll("^\"|\"$", ""));
                    String title = parts[1].replaceAll("^\"|\"$", "");
                    String authors = parts[2].replaceAll("^\"|\"$", "");
                    double averageRating = Double.parseDouble(parts[3]);
                    String isbn = parts[4].replaceAll("^\"|\"$", "");
                    String isbn13 = parts[5].replaceAll("^\"|\"$", "");
                    String languageCode = parts[6].replaceAll("^\"|\"$", "");
                    int numPages = Integer.parseInt(parts[7]);
                    int ratingsCount = Integer.parseInt(parts[8]);
                    int textReviewsCount = Integer.parseInt(parts[9]);
                    String publicationDate = parts[10].replaceAll("^\"|\"$", "");
                    String publisher = parts[11].replaceAll("^\"|\"$", "");

                    String sql = "INSERT INTO books (book_id, title, authors, average_rating, isbn, isbn13, " +
                            "language_code, num_pages, ratings_count, text_reviews_count, publication_date, publisher) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, STR_TO_DATE(?, '%m/%d/%Y'), ?)";
                    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                        pstmt.setInt(1, bookID);
                        pstmt.setString(2, title);
                        pstmt.setString(3, authors);
                        pstmt.setDouble(4, averageRating);
                        pstmt.setString(5, isbn);
                        pstmt.setString(6, isbn13);
                        pstmt.setString(7, languageCode);
                        pstmt.setInt(8, numPages);
                        pstmt.setInt(9, ratingsCount);
                        pstmt.setInt(10, textReviewsCount);
                        pstmt.setString(11, publicationDate);
                        pstmt.setString(12, publisher);
                        pstmt.executeUpdate();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing numeric value: " + e.getMessage());
                    System.err.println("Problematic line: " + line);
                }
            }
            System.out.println("Data imported successfully.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
