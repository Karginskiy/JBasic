package jbasic.model.command.cli;

import jbasic.core.ExecutionContext;

import java.util.List;

public interface Executable {
    Executable EMPTY = (context, args) -> {};
    void execute(final ExecutionContext context, final List<String> args);

    default int getNextLineNumber(final ExecutionContext context, final List<String> args) {
        throw new UnsupportedOperationException();
    }
}
