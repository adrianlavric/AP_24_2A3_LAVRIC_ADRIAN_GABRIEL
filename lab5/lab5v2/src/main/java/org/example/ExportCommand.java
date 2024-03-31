package org.example;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ExportCommand extends Command {
    @Override
    public void execute(List<String> arguments) throws CommandException {
        if(arguments.size() != 1) {
            throw new CommandException("Invalid arguments, syntax: export <output_file>");
        }

        String outputFile = arguments.get(0);

        try {
            Map<String, Object> repositoryData = new HashMap<>();
            repositoryData.put("repository", "Repository1");

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(outputFile), repositoryData);

            System.out.println("Exported to: " + outputFile);
        } catch (IOException e) {
            throw new CommandException("Error exporting repository: " + e.getMessage());
        }

    }
}
