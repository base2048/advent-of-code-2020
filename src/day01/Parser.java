package day01;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static List<Integer> parse(String text) {
        return Arrays.stream(text.split("\n")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static List<Integer> parse(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().map(Integer::valueOf).collect(Collectors.toList());
        } catch (IOException ignored) {
            return null;
        }
    }
}
