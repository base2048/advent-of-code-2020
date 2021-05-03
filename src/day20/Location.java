package day20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public enum Location {

    TOP(0),
    RIGHT(1),
    BOTTOM(2),
    LEFT(3),
    FLIPPED_TOP(4),
    FLIPPED_RIGHT(5),
    FLIPPED_BOTTOM(6),
    FLIPPED_LEFT(7);

    private final int index;
    private static Map<Integer, Location> locationByIndex;

    Location(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static Location getByIndex(int index) {
        if (locationByIndex == null)
            locationByIndex = Arrays.stream(values()).collect(Collectors.toMap(Location::getIndex, Function.identity()));

        return locationByIndex.get(index);
    }

    public static Location getByOrdinal(int ordinal) {
        return Location.values()[ordinal];
    }

    public static Stream<Location> stream() {
        return Stream.of(Location.values());
    }
}
