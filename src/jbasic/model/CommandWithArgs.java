package jbasic.model;

import jbasic.model.command.Command;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommandWithArgs {

    private Command command;
    private List<String> args;

    public static CommandWithArgs of(final Command command, final List<String> args) {
        final CommandWithArgs commandWithArgs = new CommandWithArgs();
        commandWithArgs.command = command;
        commandWithArgs.args = args;
        return commandWithArgs;
    }

    private CommandWithArgs() {}

    public Command getCommand() {
        return command == null ? Command.UNKNOWN : command;
    }

    public List<String> getArgs() {
        return args == null ? Collections.emptyList() : args;
    }

    @Override
    public String toString() {
        return command.name() + " " + args.stream().collect(Collectors.joining(" "));
    }
}
