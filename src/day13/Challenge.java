package day13;

import java.util.*;

public class Challenge {

    private final int earliestDeparture;
    private final List<Integer> buses;

    public Challenge(Parser.Dataset data) {
        this.earliestDeparture = data.earliestDeparture;
        this.buses = data.buses;
    }

    public int solvePart1() {
        return buses.stream()
                .filter(bus -> bus != 1)
                .map(bus -> new Object() {
                    final int id = bus;
                    final int delta = bus - earliestDeparture % bus;
                })
                .min(Comparator.comparingInt(bus -> bus.delta))
                .map(bus -> bus.id * bus.delta)
                .orElse(0);
    }

    public long solvePart2() {
        return getLoonyTimestamp(buses, 1, 0, 1);
    }

    private long getLoonyTimestamp(List<Integer> buses, int offset, long timestamp, long stepSize) {
        int head = buses.get(0);

        while ((timestamp + offset) % head != 0)
            timestamp += stepSize;

        if (buses.size() == 1) return timestamp + 1;
        return getLoonyTimestamp(buses.subList(1, buses.size()), offset + 1, timestamp, stepSize * head);
    }
}
