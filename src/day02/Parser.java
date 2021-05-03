package day02;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Parser {

    public static List<String> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }
}
