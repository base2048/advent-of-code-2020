package day15;

import java.util.*;

public class Challenge {

    private final List<Integer> startingNumbers;

    public Challenge(List<Integer> startingNumbers) {
        this.startingNumbers = startingNumbers;
    }

    public int solvePart1() {
        final int turns = 2020;
        final Map<Integer, Integer> indexBySpokenNumber = new HashMap<>();

        for (int i = 0; i < startingNumbers.size() - 1; i++)
            indexBySpokenNumber.put(startingNumbers.get(i), i);

        int nextNumber, lastNumber = startingNumbers.get(startingNumbers.size() - 1);

        for (int i = startingNumbers.size() - 1; i < turns - 1; i++) {
            nextNumber = i - indexBySpokenNumber.getOrDefault(lastNumber, i);
            indexBySpokenNumber.put(lastNumber, i);
            lastNumber = nextNumber;
        }

        return lastNumber;
    }

    public int solvePart2() {
        final int turns = 30_000_000;
        final int[] spokenNumbersIndex = new int[turns];
        Arrays.fill(spokenNumbersIndex, -1);

        for (int i = 0; i < startingNumbers.size() - 1; i++)
            spokenNumbersIndex[startingNumbers.get(i)] = i;

        int nextNumber, lastNumber = startingNumbers.get(startingNumbers.size() - 1);

        for (int i = startingNumbers.size() - 1; i < turns - 1; i++) {
            int lastNumberIndex = spokenNumbersIndex[lastNumber];
            nextNumber = lastNumberIndex == -1 ? 0 : i - lastNumberIndex;

            spokenNumbersIndex[lastNumber] = i;
            lastNumber = nextNumber;
        }

        return lastNumber;
    }
}
