package day08;

import java.util.*;

public class Computer {

    private Program program;
    private int accumulator;
    private int exitCode = -1;

    public Computer run() {
        List<Instruction> code = program.getCode();
        int executionPointer = 0;
        Instruction instruction;
        accumulator = 0;

        while (executionPointer < code.size() && (instruction = code.get(executionPointer)).getCallCtr() == 0) {
            switch (instruction.getOperation()) {
                case ACC -> {
                    accumulator += instruction.getArgument();
                    executionPointer++;
                }
                case JMP -> executionPointer += instruction.getArgument();
                case NOP -> executionPointer++;
            }
            instruction.incrementCallCtr();
        }
        exitCode = executionPointer < code.size() ? 1 : 0;
        return this;
    }

    public Computer loadProgram(Program program) {
        this.program = program;
        return this;
    }

    public Computer ejectProgram() {
        this.program = null;
        return this;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public int getExitCode() {
        return exitCode;
    }
}
