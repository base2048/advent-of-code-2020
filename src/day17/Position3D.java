package day17;

public class Position3D extends Position {

    public Position3D(int x, int y, int z) {
        super(x, y, z);
    }

    public static Position3D addVector(Position3D pos, Vector3D vector) {
        return new Position3D(
                pos.x + vector.direction.x * vector.length,
                pos.y + vector.direction.y * vector.length,
                pos.z + vector.direction.z * vector.length);
    }

    @Override
    public String toString() {
        return "(" + x + "|" + y + "|" + z + ")";
    }
}
