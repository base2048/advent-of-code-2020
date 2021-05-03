package day08;

public abstract class Instruction {

    private final Operation operation;
    private final int argument;
    private int callCtr = 0;

    public Instruction(Operation operation, int argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getArgument() {
        return argument;
    }

    public int getCallCtr() {
        return callCtr;
    }

    public void incrementCallCtr() {
        callCtr++;
    }

    public void resetCallCtr() {
        callCtr = 0;
    }
}
