package day08;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static List<Instruction> parse(String text) {
        return Arrays.stream(text.split("\n")).map(Parser::parseInstruction).collect(Collectors.toList());
    }

    public static List<Instruction> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream().map(Parser::parseInstruction).collect(Collectors.toList());
    }

    private static Instruction parseInstruction(String instruction) {
        String[] tokens = instruction.split(" ");
        int argument = Integer.parseInt(tokens[1]);

        return switch (tokens[0]) {
            case "acc" -> new Acc(argument);
            case "jmp" -> new Jmp(argument);
            case "nop" -> new Nop(argument);
            default -> throw new IllegalArgumentException();
        };
    }
}
