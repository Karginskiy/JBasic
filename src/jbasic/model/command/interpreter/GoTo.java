package jbasic.model.command.interpreter;

import jbasic.core.ExecutionContext;
import jbasic.model.command.cli.Executable;

import java.util.List;

public final class GoTo implements Executable {

    @Override
    public int getNextLineNumber(final ExecutionContext context, final List<String> args) {
        if (args.isEmpty()) {
            return -1;
        }

        try {
            return Integer.parseInt(args.get(0));
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    @Override
    public void execute(final ExecutionContext context, final List<String> args) {
        throw new UnsupportedOperationException();
    }
}
