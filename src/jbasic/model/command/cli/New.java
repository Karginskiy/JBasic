package jbasic.model.command.cli;

import jbasic.core.ExecutionContext;

import java.util.List;

public final class New implements Executable {
    @Override
    public void execute(final ExecutionContext context, final List<String> args) {
        context.getProgramBuffer().clear();
    }
}
