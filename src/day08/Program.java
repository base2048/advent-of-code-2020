package day08;

import java.util.List;

public class Program {

    private final List<Instruction> code;
    private int modificationPointer = -1;

    public Program(List<Instruction> code) {
        this.code = code;
    }

    public Program modifyCode() {
        code.forEach(Instruction::resetCallCtr);

        if (modificationPointer >= 0)
            toggleInstruction(modificationPointer);

        Operation operation;
        for (++modificationPointer; modificationPointer < code.size(); modificationPointer++) {
            if ((operation = code.get(modificationPointer).getOperation()) == Operation.JMP || operation == Operation.NOP) {
                toggleInstruction(modificationPointer);
                return this;
            }
        }
        return this;
    }

    private void toggleInstruction(int pointer) {
        Instruction current = code.get(pointer);
        code.set(pointer, current.getOperation() == Operation.JMP ? new Nop(current.getArgument()) : new Jmp(current.getArgument()));
    }

    public List<Instruction> getCode() {
        return code;
    }
}
