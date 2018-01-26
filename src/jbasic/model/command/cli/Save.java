package jbasic.model.command.cli;

import jbasic.core.ExecutionContext;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public final class Save implements Executable {

    private static final String FILE_EXT = ".bas";
    private static final String NO_FILENAME = "No filename has been entered.";
    private static final String FILE_NOT_FOUND = "No file found for given filename.";

    @Override
    public void execute(final ExecutionContext context, final List<String> args) {
        if (args.isEmpty()) {
            context.getOutput().println(NO_FILENAME);
            return;
        }

        final String fileName = args.get(0) + FILE_EXT;

        try (final PrintWriter writer = new PrintWriter(fileName)){
            context.getProgramBuffer()
                    .getLinesWithNumbers()
                    .forEach((lineNumber, lineContent) -> writer.println(lineNumber + " " + lineContent));
        } catch (FileNotFoundException ex) {
            context.getOutput().println(FILE_NOT_FOUND);
        }
    }
}
