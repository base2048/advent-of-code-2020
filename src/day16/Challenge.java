package day16;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Challenge {

    private final List<Rule> rules;
    private final List<Integer> myTicket;
    private final List<List<Integer>> nearbyTickets;

    public Challenge(Parser.Dataset data) {
        this.rules = data.rules;
        this.myTicket = data.myTicket;
        this.nearbyTickets = data.nearbyTickets;
    }

    public int solvePart1() {
        return nearbyTickets.stream()
                .flatMap(Collection::stream)
                .filter(Predicate.not(this::isWithinValidRanges))
                .reduce(0, Integer::sum);
    }

    public long solvePart2() {
        List<List<Integer>> validTickets = getValidTickets();
        List<List<Integer>> groupedValues = groupValuesByPosition(validTickets);

        Map<Integer, List<String>> potentialFieldNamesByPosition = assignPotentialFieldNamesToPosition(groupedValues);
        Map<Integer, String> verifiedFieldNamesByPosition = determineFieldNames(potentialFieldNamesByPosition, new HashMap<>());

        return multiplyAllDepartureFieldsOfMyTicket(verifiedFieldNamesByPosition);
    }

    private boolean isWithinValidRanges(int number) {
        return rules.stream().anyMatch(rule -> rule.isValueValid(number));
    }

    private List<List<Integer>> getValidTickets() {
        return nearbyTickets.stream()
                .filter(ticket -> ticket.stream().allMatch(this::isWithinValidRanges))
                .collect(Collectors.toList());
    }

    private List<List<Integer>> groupValuesByPosition(List<List<Integer>> tickets) {
        return IntStream.range(0, tickets.get(0).size())
                .mapToObj(pos -> tickets.stream()
                        .map(ticket -> ticket.get(pos))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private Map<Integer, List<String>> assignPotentialFieldNamesToPosition(List<List<Integer>> groupedValues) {
        return IntStream.range(0, groupedValues.size())
                .mapToObj(i -> rules.stream()
                        .filter(rule -> groupedValues.get(i).stream().allMatch(rule::isValueValid))
                        .map(rule -> new Object() { final int pos = i; final String fieldName = rule.getFieldName(); }))
                .flatMap(Function.identity())
                .collect(Collectors.groupingBy(token -> token.pos, Collectors.mapping(token -> token.fieldName, Collectors.toList())));
    }

    private Map<Integer, String> determineFieldNames(Map<Integer, List<String>> potentialFieldNames, Map<Integer, String> verifiedFieldNames) {
        if (potentialFieldNames.isEmpty()) return verifiedFieldNames;

        potentialFieldNames.entrySet().removeIf(entry -> {
            if (entry.getValue().size() > 1) return false;

            String verifiedField = entry.getValue().get(0);
            verifiedFieldNames.put(entry.getKey(), verifiedField);
            potentialFieldNames.forEach((key, value) -> value.remove(verifiedField));

            return true;
        });

        return determineFieldNames(potentialFieldNames, verifiedFieldNames);
    }

    private long multiplyAllDepartureFieldsOfMyTicket(Map<Integer, String> verifiedFieldNamesByPosition) {
        return verifiedFieldNamesByPosition.entrySet().stream()
                .filter(entry -> entry.getValue().startsWith("departure"))
                .mapToLong(entry -> myTicket.get(entry.getKey()))
                .reduce(1, (acc, val) -> acc * val);
    }
}
