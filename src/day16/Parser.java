package day16;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    public static Dataset parse(String text) {
        return parseData(text.split("\n\n"));
    }

    public static Dataset parse(File file) throws IOException {
        return parseData(Files.readString(file.toPath()).replaceAll("\r", "").split("\n\n"));
    }

    private static Dataset parseData(String[] chunks) {
        return new Dataset(
                parseRules(chunks[0]),
                parseMyTicket(chunks[1]),
                parseNearbyTickets(chunks[2]));
    }

    private static List<Rule> parseRules(String rules) {
        Pattern rulesPAT = Pattern.compile("^([\\w ]+): (\\d+)-(\\d+) or (\\d+)-(\\d+)$");

        return Arrays.stream(rules.split("\n"))
                .map(rule -> {
                    Matcher matcher = rulesPAT.matcher(rule);
                    matcher.find();
                    int[] lowerValueRange = {Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))};
                    int[] higherValueRange = {Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5))};
                    return new Rule(matcher.group(1), lowerValueRange, higherValueRange);
                })
                .collect(Collectors.toList());
    }

    private static List<Integer> parseMyTicket(String myTicket) {
        return Arrays.stream(myTicket.split("\n")[1].split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static List<List<Integer>> parseNearbyTickets(String tickets) {
        return Arrays.stream(tickets.split("\n"))
                .skip(1)
                .map(ticket -> Arrays.stream(ticket.split(",")).map(Integer::valueOf).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    protected static class Dataset {
        protected final List<Rule> rules;
        protected final List<Integer> myTicket;
        protected final List<List<Integer>> nearbyTickets;

        private Dataset(List<Rule> rules, List<Integer> myTicket, List<List<Integer>> nearbyTickets) {
            this.rules = rules;
            this.myTicket = myTicket;
            this.nearbyTickets = nearbyTickets;
        }
    }
}
