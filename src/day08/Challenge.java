package day08;

import java.util.List;

public class Challenge {

    private final Program program;

    public Challenge(List<Instruction> code) throws Exception {
        this.program = new Program(code);
    }

    public int solvePart1() {
        Computer computer = new Computer();
        return computer.loadProgram(program).run().getAccumulator();
    }

    public int solvePart2() {
        Computer computer = new Computer();
        computer.loadProgram(program);

        while (computer.run().getExitCode() > 0)
            computer.ejectProgram().loadProgram(program.modifyCode());

        return computer.getAccumulator();
    }
}
