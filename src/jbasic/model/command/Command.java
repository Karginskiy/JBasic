package jbasic.model.command;

import jbasic.core.ExecutionContext;
import jbasic.model.command.cli.*;
import jbasic.model.command.interpreter.GoTo;
import jbasic.model.command.interpreter.Input;

import static jbasic.model.command.CommandType.BRANCH;
import static jbasic.model.command.CommandType.LINE;
import static jbasic.model.command.cli.Executable.EMPTY;

public enum Command {

    NEW("new", new New(), LINE),
    LIST("list", new List(), LINE),
    VALUES("values", new Values(), LINE),
    DELETE("delete", new Delete(), LINE),
    SAVE("save", new Save(), LINE),
    LOAD("load", new Load(), LINE),
    RUN("run", new Run(), LINE),
    EXIT("exit", EMPTY, LINE),
    UNKNOWN("unknown", EMPTY, LINE),

    INPUT("input", new Input(), LINE),
    GOTO("goto", new GoTo(), BRANCH);

    private final String name;
    private final Executable executor;
    private final CommandType type;

    Command(String name, Executable executor, CommandType type) {
        this.name = name;
        this.executor = executor;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public CommandType getType() { return type; }

    public void execute(ExecutionContext context, java.util.List<String> args) {
        this.executor.execute(context, args);
    }

    public int executeBranched(ExecutionContext context, java.util.List<String> args) {
        return this.executor.getNextLineNumber(context, args);
    }

}
