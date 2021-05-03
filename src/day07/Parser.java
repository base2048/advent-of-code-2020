package day07;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern bagContentPAT = Pattern.compile("(\\d+) (\\w+ \\w+)");

    public static List<Bag> parse(String text) {
        return Arrays.stream(text.split("\n")).map(Parser::parseBag).collect(Collectors.toList());
    }

    public static List<Bag> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream().map(Parser::parseBag).collect(Collectors.toList());
    }

    public static Bag parseBag(String bag) {
        String[] token = bag.split(" bags contain ");

        String color = token[0];
        Map<String, Integer> content = new HashMap<>();

        Matcher matcher = bagContentPAT.matcher(bag);
        while (matcher.find()) {
            content.put(matcher.group(2), Integer.parseInt(matcher.group(1)));
        }

        return new Bag(color, content);
    }
}
