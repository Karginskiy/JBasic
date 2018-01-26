package jbasic.model.command.cli;

import jbasic.core.ExecutionContext;

public final class List implements Executable {
    @Override
    public void execute(final ExecutionContext context, final java.util.List<String> args) {
        context.getProgramBuffer()
                .getLinesWithNumbers()
                .forEach((lineNumber, commandWithArgs) ->
                                context.getOutput().println(lineNumber + " " + commandWithArgs));
    }
}
