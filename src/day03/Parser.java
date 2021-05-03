package day03;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static List<String> parse(String text) {
        return Arrays.stream(text.split("\n")).collect(Collectors.toList());
    }

    public static List<String> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }
}
