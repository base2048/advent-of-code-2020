package day25;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class Parser {

    public static int[] parse(String text) {
        return Arrays.stream(text.split("\n")).mapToInt(Parser::parseKeys).toArray();
    }

    public static int[] parse(File file) throws IOException {
        return Arrays.stream(Files.readString(file.toPath()).replaceAll("\r", "").split("\n"))
                .mapToInt(Parser::parseKeys).toArray();
    }

    private static int parseKeys(String key) {
        return Integer.parseInt(key);
    }
}
