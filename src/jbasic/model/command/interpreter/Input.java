package jbasic.model.command.interpreter;

import jbasic.core.ExecutionContext;
import jbasic.model.command.cli.Executable;

import java.util.List;

public final class Input implements Executable {

    private static final String ENTER_CHAR = "? ";

    @Override
    public void execute(final ExecutionContext context, final List<String> args) {
        context.getOutput().print(ENTER_CHAR);

        String variableName = "";

        if (!args.isEmpty()) {
            variableName = args.get(0);
        }

        context.getProgramBuffer().addVariable(variableName, context.getInput().nextDouble());
    }
}
