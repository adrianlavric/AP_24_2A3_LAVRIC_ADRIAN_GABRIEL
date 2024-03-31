package org.example;
import java.util.List;

public abstract class Command {
    abstract void execute(List<String> arguments) throws CommandException;
}
