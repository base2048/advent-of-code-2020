package day14;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;

public class Parser {

    public static List<Mask> parse(String text) {
        return parseToMasks(text.split("\n"));
    }

    public static List<Mask> parse(File file) throws IOException {
        return parseToMasks(Files.readAllLines(file.toPath()).toArray(String[]::new));
    }

    private static List<Mask> parseToMasks(String[] data) {
        Pattern memoryPAT = Pattern.compile("^mem\\[(\\d+)\\] = (\\d+)");
        Matcher matcher;

        int i = 0;
        List<Mask> masks = new ArrayList<>();

        while (i < data.length) {
            Mask mask = new Mask(data[i].split(" = ")[1]);

            while (++i < data.length && (matcher = memoryPAT.matcher(data[i])).find())
                mask.getMemories().add(new Memory(Integer.parseInt(matcher.group(1)), Long.parseLong(matcher.group(2))));

            masks.add(mask);
        }
        return masks;
    }
}
