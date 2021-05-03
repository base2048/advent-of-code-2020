package day10;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Challenge {

    private final List<Integer> adapters;

    public Challenge(List<Integer> adapters) {
        this.adapters = adapters;
        this.adapters.sort(Integer::compareTo);
    }

    public int solvePart1() {
        List<Integer> adapters = new ArrayList<>(this.adapters);
        int deviceBuiltInJoltageAdapter = adapters.get(adapters.size() - 1) + 3;
        adapters.add(deviceBuiltInJoltageAdapter);

        AtomicInteger currentJolts = new AtomicInteger(0);
        List<Integer> deltas = adapters.stream()
                .map(adapter -> adapter - currentJolts.getAndSet(adapter))
                .collect(Collectors.toList());

        return Collections.frequency(deltas, 1) * Collections.frequency(deltas, 3);
    }

    public long solvePart2() {
        List<Integer> adapters = new ArrayList<>(this.adapters);
        int chargingOutletJoltageRating = 0;
        adapters.add(0, chargingOutletJoltageRating);
        /*
         * No need to add device built-in joltage adapter:
         * all graphs which hit the last adapter must be valid.
         */

        long[] cache = new long[adapters.size()];
        Arrays.fill(cache, -1);

        return countArrangements(adapters, 0, cache);
    }

    private long countArrangements(List<Integer> adapters, int index, long[] cache) {
        if (cache[index] > -1) return cache[index];
        if (index == adapters.size() - 1) return 1;

        long validPaths = 0;

        if (adapters.size() > index + 1 && adapters.get(index + 1) - adapters.get(index) <= 3)
            validPaths += countArrangements(adapters, index + 1, cache);

        if (adapters.size() > index + 2 && adapters.get(index + 2) - adapters.get(index) <= 3)
            validPaths += countArrangements(adapters, index + 2, cache);

        if (adapters.size() > index + 3 && adapters.get(index + 3) - adapters.get(index) <= 3)
            validPaths += countArrangements(adapters, index + 3, cache);

        return cache[index] = validPaths;
    }
}
