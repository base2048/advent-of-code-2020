package day11;

public class Position {

    public final int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position addVector(Position pos, Vector vector) {
        return new Position(
                pos.x + vector.getDirection().getX() * vector.getLength(),
                pos.y + vector.getDirection().getY() * vector.getLength());
    }
}
