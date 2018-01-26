package jbasic.model.command.cli;

import jbasic.core.ExecutionContext;

import java.util.List;

public final class Values implements Executable {
    @Override
    public void execute(final ExecutionContext context, final List<String> args) {
        context.getOutput().println(context.getProgramBuffer().getVariables());
    }
}
