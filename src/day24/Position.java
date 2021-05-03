package day24;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Position {

    public int q, r, hash;

    public Position(int q, int r) {
        this.q = q;
        this.r = r;
        this.hash = computeHash();
    }

    public void addVector(Vector vector) {
        q += vector.direction.q * vector.length;
        r += vector.direction.r * vector.length;
        hash = computeHash();
    }

    private static Position addVector(Position pos, Vector vector) {
        return new Position(pos.q + vector.direction.q * vector.length,
                pos.r + vector.direction.r * vector.length);
    }

    public static Position determinePosition(List<Vector> cartesianPath) {
        Position position = new Position(0, 0);
        cartesianPath.forEach(position::addVector);

        position.hash = position.computeHash();
        return position;
    }

    private int computeHash() {
        return q + (r << 8);
    }

    public List<Position> getNeighborPositions() {
        return Direction.stream()
                .map(dir -> Position.addVector(this, dir.getUnitVector()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;
        return hash == position.hash;
    }

    @Override
    public int hashCode() {
        return hash;
    }
}
