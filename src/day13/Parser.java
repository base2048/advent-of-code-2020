package day13;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static Dataset parse(String text) {
        return parseData(text.split("\n"));
    }

    public static Dataset parse(File file) throws IOException {
        return parseData(Files.readAllLines(file.toPath()).toArray(String[]::new));
    }

    private static Dataset parseData(String[] tokens) {
        int earliestDeparture = Integer.parseInt(tokens[0]);

        List<Integer> buses = Arrays.stream(tokens[1].split(","))
                .map(bus -> bus.equals("x") ? 1 : Integer.parseInt(bus))
                .collect(Collectors.toList());

        return new Dataset(earliestDeparture, buses);
    }

    protected static class Dataset {
        protected final int earliestDeparture;
        protected final List<Integer> buses;

        private Dataset(int earliestDeparture, List<Integer> buses) {
            this.earliestDeparture = earliestDeparture;
            this.buses = buses;
        }
    }
}
