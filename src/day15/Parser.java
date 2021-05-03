package day15;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static List<Integer> parse(String text) {
        return Arrays.stream(text.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static List<Integer> parse(File file) throws IOException {
        return Arrays.stream(Files.readString(file.toPath()).split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
