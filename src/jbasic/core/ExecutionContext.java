package jbasic.core;

import jbasic.model.CommandWithArgs;

import java.io.PrintStream;
import java.util.Scanner;

public final class ExecutionContext {

    private final Scanner input;
    private final ProgramBuffer programBuffer;
    private final PrintStream output;
    private final InputParser parser;

    public ExecutionContext() {
        this.input = new Scanner(System.in);
        this.output = new PrintStream(System.out);
        this.programBuffer = new ProgramBuffer();
        this.parser = new InputParser();
    }

    public Scanner getInput() {
        return input;
    }

    public PrintStream getOutput() {
        return output;
    }

    public ProgramBuffer getProgramBuffer() {
        return programBuffer;
    }

    public CommandWithArgs getCommandFromRawString(String str) {
        return this.parser.parse(str);
    }

    CommandWithArgs getNextCommandWithArgs() {
        return this.parser.parse(input.nextLine());
    }

}
