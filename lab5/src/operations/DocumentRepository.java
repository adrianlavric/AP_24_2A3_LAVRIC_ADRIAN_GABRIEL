package operations;

import personal.Person;
import personal.Document;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class DocumentRepository {
    private Path masterDirectoryPath;

    public DocumentRepository(String masterDirectoryPath) throws IOException {
        Path masterPath = Paths.get(masterDirectoryPath);

        if (!Files.exists(masterPath) || !Files.isDirectory(masterPath)) {
            throw new IllegalArgumentException("Invalid path!");
        }

        this.masterDirectoryPath = masterPath;

    }

    public void displayContent() {
        try(DirectoryStream<Path> masterDirectoryStream = Files.newDirectoryStream(masterDirectoryPath)) {
            for (Path currentDocument : masterDirectoryStream) {
                if (Files.isDirectory(currentDocument)) {
                    System.out.println("Sub-directory: " + currentDocument.getFileName());
                }
//                if (Files.isRegularFile(currentDocument)) {
//                    System.out.println("File: " + currentDocument.getFileName());
//                }
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.err.println("Error reading the directory: " + e.getMessage());
        }
    }

    public void displayEmployeeDocuments(Person person) {
        System.out.println("Documents of " + person.name() + person.uniqueID() + ":");
        List<Document> documents = new ArrayList<>();
        String employeeDocumentsName = person.name() + person.uniqueID();
        Path employeeDocumentPath = masterDirectoryPath.resolve(employeeDocumentsName);

        try (DirectoryStream<Path> employeeDirectoryStream = Files.newDirectoryStream(employeeDocumentPath)) {
            for (Path currentDocument : employeeDirectoryStream) {
                if (!Files.isDirectory(currentDocument)) {
                    documents.add(new Document(currentDocument));
                }
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.err.println("Error reading the directory: " + e.getMessage());
        }

        for (Document document : documents) {
            System.out.println(document.path());
        }
    }
}
