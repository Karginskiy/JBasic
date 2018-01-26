package jbasic.core;

import jbasic.model.CommandWithArgs;

import java.util.*;

public final class ProgramBuffer {

    private final Map<Integer, CommandWithArgs> lines = new LinkedHashMap<>();
    private final Map<String, Double> variables = new HashMap<>();

    public CommandWithArgs getLine(final int index) {
        return lines.getOrDefault(index, null);
    }

    public void addVariable(final String name, final double variable) {
        this.variables.put(name, variable);
    }

    public double getVariable(final String name) {
        return variables.getOrDefault(name, Double.NaN);
    }

    public void addLine(final CommandWithArgs line) {
        lines.put(lines.keySet().size(), line);
    }

    public Collection<CommandWithArgs> getLines() {
        return lines.values();
    }

    public Map<Integer, CommandWithArgs> getLinesWithNumbers() {
        return lines;
    }

    public Map<String, Double> getVariables() {
        return variables;
    }

    public void removeLine(final int index) {
        lines.remove(index);
    }

    public void clear() {
        variables.clear();
        lines.clear();
    }

}
