package day17;

import java.util.*;

public class Direction3D extends Direction {

    private static final List<Direction3D> allDirections = new ArrayList<>();

    static {
        for (int x : units)
            for (int y : units)
                for (int z : units)
                    if (!Direction.isCenter(new int[]{x, y, z}))
                        allDirections.add(new Direction3D(x, y, z));
    }

    public Direction3D(int x, int y, int z) {
        super(x, y, z);
    }

    public static List<Direction3D> getAllDirections() {
        return allDirections;
    }
}
