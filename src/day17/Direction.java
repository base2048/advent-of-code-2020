package day17;

public abstract class Direction {

    public final int x, y, z;

    protected static final int[] units = new int[]{-1, 0, 1};

    public Direction(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    protected static boolean isCenter(int[] coords) {
        for (int val : coords)
            if (val != 0) return false;

        return true;
    }
}
