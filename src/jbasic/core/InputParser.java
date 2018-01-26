package jbasic.core;

import jbasic.model.CommandWithArgs;
import jbasic.model.command.Command;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static jbasic.model.command.Command.UNKNOWN;

public final class InputParser {

    private final Map<String, Command> mapping =
            Stream.of(Command.values()).collect(toMap(Command::getName, identity()));

    public CommandWithArgs parse(final String text) {
        if (text == null) {
            return null;
        }

        final String[] commandAndArgs = text.split(" ");

        return CommandWithArgs.of(
                mapping.getOrDefault(commandAndArgs.length != 0 ? commandAndArgs[0] : "", UNKNOWN),
                commandAndArgs.length >= 1
                        ? Arrays.stream(commandAndArgs).skip(1).collect(toList())
                        : Collections.emptyList());
    }


}
