package day17;

public class Position4D extends Position {

    public final int w;

    public Position4D(int x, int y, int z, int w) {
        super(x, y, z);
        this.w = w;
    }

    public static Position4D addVector(Position4D pos, Vector4D vector) {
        return new Position4D(
                pos.x + vector.direction.x * vector.length,
                pos.y + vector.direction.y * vector.length,
                pos.z + vector.direction.z * vector.length,
                pos.w + vector.direction.w * vector.length);
    }

    @Override
    public String toString() {
        return "(" + x + "|" + y + "|" + z + "|" + w + ")";
    }
}
