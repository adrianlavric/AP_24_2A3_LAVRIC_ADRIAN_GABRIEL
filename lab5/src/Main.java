import operations.DocumentRepository;
import personal.Person;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String masterDirectoryPath = "C:\\Users\\adria\\OneDrive\\Desktop\\MasterDirectory";

        DocumentRepository repository = null;
        try {
            repository = new DocumentRepository(masterDirectoryPath);
        } catch (IOException e) {
            System.err.println("Error initializing the repository: " + e.getMessage());
        }

        System.out.println("Master directory content:");
        repository.displayContent();

        Person person = new Person("employee", "2");
        repository.displayEmployeeDocuments(person);

    }

}