package jbasic.model.command.cli;

import jbasic.core.ExecutionContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public final class Load implements Executable {

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

        try (final Stream<String> readStream = Files.lines(Paths.get(fileName))){
            context.getProgramBuffer().clear();

            readStream.forEachOrdered(line -> context.getProgramBuffer().addLine(context.getCommandFromRawString(line)));
        } catch (IOException ex) {
            context.getOutput().println(FILE_NOT_FOUND);
        }
    }
}
