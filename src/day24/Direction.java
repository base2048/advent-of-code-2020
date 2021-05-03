package day24;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public enum Direction {

    E(1, 0, Pattern.compile("^e")),
    SE(0, 1, Pattern.compile("^se")),
    SW(-1, 1, Pattern.compile("^sw")),
    W(-1, 0, Pattern.compile("^w")),
    NW(0, -1, Pattern.compile("^nw")),
    NE(1, -1, Pattern.compile("^ne"));

    public final int q, r;
    private final Pattern pattern;

    Direction(int q, int r, Pattern pattern) {
        this.q = q;
        this.r = r;
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Vector getUnitVector() {
        return new Vector(Direction.this, 1);
    }

    public static Stream<Direction> stream() {
        return Stream.of(Direction.values());
    }
}
