package day24;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class Parser {

    public static List<String> parse(String text) {
        return List.of(text.split("\n"));
    }

    public static List<String> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }
}
