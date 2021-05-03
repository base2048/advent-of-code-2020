package day11;

public class Vector {

    private final Direction direction;
    private final int length;

    public Vector(Direction direction, int length) {
        this.direction = direction;
        this.length = length;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }
}
