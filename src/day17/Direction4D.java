package day17;

import java.util.*;

public class Direction4D extends Direction {

    public final int w;

    private static final List<Direction4D> allDirections = new ArrayList<>();

    static {
        for (int x : units)
            for (int y : units)
                for (int z : units)
                    for (int w : units)
                        if (!Direction.isCenter(new int[]{x, y, z, w}))
                            allDirections.add(new Direction4D(x, y, z, w));
    }

    public Direction4D(int x, int y, int z, int w) {
        super(x, y, z);
        this.w = w;
    }

    public static List<Direction4D> getAllDirections() {
        return allDirections;
    }
}
