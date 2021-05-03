package day23;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Parser {

    public static CupList parse(String text) {
        return Arrays.stream(text.split(""))
                .map(Integer::parseInt)
                .collect(CupList::new, CupList::add, CupList::addAll);
    }

    public static CupList parse(File file) throws IOException {
        return Arrays.stream(Files.readString(file.toPath()).split(""))
                .map(Integer::parseInt)
                .collect(CupList::new, CupList::add, CupList::addAll);
    }
}
