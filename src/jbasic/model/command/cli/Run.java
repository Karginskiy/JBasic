package jbasic.model.command.cli;

import jbasic.core.ExecutionContext;
import jbasic.interpreter.Interpreter;

import java.util.List;

public final class Run implements Executable {
    @Override
    public void execute(final ExecutionContext context, final List<String> args) {
        new Interpreter().run(context);
    }
}
