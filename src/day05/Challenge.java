package day05;

import java.util.*;
import java.util.stream.*;

public class Challenge {

    private final List<Seat> seats;

    public Challenge(List<Seat> seats) {
        this.seats = seats;
    }

    public int solvePart1() {
        return seats.stream()
                .max(Comparator.comparingInt(Seat::getId))
                .orElseThrow(NoSuchElementException::new)
                .getId();
    }

    public int solvePart2() {
        List<Integer> seatIdsSorted = seats.stream()
                .map(Seat::getId)
                .sorted()
                .collect(Collectors.toList());

        final boolean SHOULD_FIND_ID_RECURSIVELY = true;

        return SHOULD_FIND_ID_RECURSIVELY
                ? findSeatInBetweenRecursively(seatIdsSorted)
                : findSeatInBetweenBySubtraction(seatIdsSorted);
    }

    private int findSeatInBetweenRecursively(List<Integer> seatIds) {
        if (seatIds.size() < 2) throw new IllegalStateException();
        if (seatIds.get(0) + 2 == seatIds.get(1)) return seatIds.get(0) + 1;

        return findSeatInBetweenRecursively(seatIds.subList(1, seatIds.size()));
    }

    private int findSeatInBetweenBySubtraction(List<Integer> seatIds) {
        return IntStream.rangeClosed(seatIds.get(0), seatIds.get(seatIds.size() - 1)).sum() -
                seatIds.stream().mapToInt(Integer::intValue).sum();
    }
}
