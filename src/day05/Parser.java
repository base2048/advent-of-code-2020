package day05;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Seat> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream().map(Seat::new).collect(Collectors.toList());
    }
}
