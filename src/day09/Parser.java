package day09;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class Parser {

    public static long[] parse(String text) {
        return Arrays.stream(text.split("\n"))
                .mapToLong(Long::parseLong)
                .toArray();
    }

    public static long[] parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream()
                .mapToLong(Long::parseLong)
                .toArray();
    }
}
