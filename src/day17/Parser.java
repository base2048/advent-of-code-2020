package day17;

import java.io.*;
import java.nio.file.Files;

public class Parser {

    public static String[] parse(String text) {
        return text.split("\n");
    }

    public static String[] parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).toArray(String[]::new);
    }
}
