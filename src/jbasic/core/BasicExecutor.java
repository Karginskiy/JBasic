package jbasic.core;

import jbasic.model.CommandWithArgs;
import jbasic.model.command.Command;

public final class BasicExecutor {

    private static final String PROMPT = "> ";
    private static final String UNKNOWN_COMMAND = "Unknown command entered. Please try another one.";

    private final ExecutionContext executionContext;

    public BasicExecutor() {
        this.executionContext = new ExecutionContext();
    }

    public void run() {
        try {
            while (true) {
                executionContext.getOutput().print(PROMPT);

                final CommandWithArgs commandWithArgs = executionContext.getNextCommandWithArgs();
                final Command command = commandWithArgs.getCommand();

                if (command == Command.EXIT) {
                    break;
                }

                if (command == Command.UNKNOWN) {
                    executionContext.getOutput().println(UNKNOWN_COMMAND);
                    continue;
                }

                command.execute(executionContext, commandWithArgs.getArgs());
            }
        } finally {
            this.executionContext.getInput().close();
            this.executionContext.getOutput().close();
        }
    }

}
