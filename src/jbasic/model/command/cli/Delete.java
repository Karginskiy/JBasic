package jbasic.model.command.cli;

import jbasic.core.ExecutionContext;

import java.util.List;

public final class Delete implements Executable {

    private final static String INCORRECT_INPUT = "Incorrect line index.";

    @Override
    public void execute(final ExecutionContext context, final List<String> args) {
        if (args.isEmpty()) {
            context.getOutput().println(INCORRECT_INPUT);
            return;
        }

        try {
            final int lineIndex = Integer.parseInt(args.get(0));
            context.getProgramBuffer().removeLine(lineIndex);
        } catch (NumberFormatException e) {
            context.getOutput().println(INCORRECT_INPUT);
        }

    }
}
