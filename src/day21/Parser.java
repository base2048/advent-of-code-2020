package day21;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern foodPAT = Pattern.compile("^([\\w ]*) \\(contains ([\\w, ]*)\\)$");

    public static List<Food> parse(String text) {
        return Arrays.stream(text.split("\n")).map(Parser::parseFood).collect(Collectors.toList());
    }

    public static List<Food> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream().map(Parser::parseFood).collect(Collectors.toList());
    }

    public static Food parseFood(String food) {
        Matcher matcher = foodPAT.matcher(food);
        matcher.find();

        return new Food(List.of(matcher.group(1).split(" ")), List.of(matcher.group(2).split(", ")));
    }
}
