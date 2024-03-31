package org.example;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ViewCommand extends Command {
    @Override
    public void execute(List<String> arguments) throws CommandException {
        if(arguments.size() != 1) {
            throw new CommandException("Invalid arguments, syntax: view <path>");
        }

        String documentPath = arguments.get(0);
        try {
            File file = new File(documentPath);

            if (!file.exists()) {
                throw new CommandException("File doesnt exist.");
            }

            if (!Desktop.isDesktopSupported()) {
                throw new CommandException("Desktop is not supported.");
            }

            Desktop.getDesktop().open(file);
        } catch(IOException e) {
            throw new CommandException("Error opening document: " + e.getMessage());
        }
    }
}
