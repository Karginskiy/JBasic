package jbasic.interpreter;

import jbasic.core.ExecutionContext;
import jbasic.model.CommandWithArgs;
import jbasic.model.command.Command;
import jbasic.model.command.CommandType;

import java.util.Map;

public final class Interpreter {

    private static final String SYNTAX_ERROR = "Syntax error or crashed data found during execution. Stopped.";
    private static final int WRONG_BRANCH_INSTRUCTION_GIVEN = -1;

    public void run(ExecutionContext context) {
        final Map<Integer, CommandWithArgs> allLines = context.getProgramBuffer().getLinesWithNumbers();
        int lineNumber = 0;

        while (lineNumber < allLines.size()) {
            if (lineNumber == WRONG_BRANCH_INSTRUCTION_GIVEN) {
                context.getOutput().println(SYNTAX_ERROR);
                break;
            }

            final CommandWithArgs commandWithArgs = allLines.get(lineNumber);
            final Command command = commandWithArgs.getCommand();

            if (command.getType() == CommandType.LINE) {
                command.execute(context, commandWithArgs.getArgs());
                lineNumber++;
            } else {
                lineNumber = command.executeBranched(context, commandWithArgs.getArgs());
            }
        }
    }
}
