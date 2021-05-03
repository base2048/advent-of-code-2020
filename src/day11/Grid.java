package day11;

import java.util.*;
import java.util.stream.Stream;

public class Grid {

    private final int width, height;
    private final Tile[][] tiles;

    public Grid(Tile[][] tiles) {
        this.width = tiles.length;
        this.height = tiles[0].length;
        this.tiles = tiles;
    }

    public Grid runOccupation(int radiusMax, int occupationThreshold) {
        boolean isStable = false;

        while (!isStable) {
            isStable = true;
            List<Seat> seatsToToggleOccupation = new ArrayList<>();

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    Tile tile = tiles[x][y];
                    if (tile instanceof Seat && shallToggleOccupation((Seat) tile, radiusMax, occupationThreshold)) {
                        seatsToToggleOccupation.add((Seat) tile);
                        isStable = false;
                    }
                }
            }

            if (!seatsToToggleOccupation.isEmpty())
                seatsToToggleOccupation.forEach(Seat::toggleOccupation);
        }
        return this;
    }

    private boolean shallToggleOccupation(Seat seat, int radiusMax, int occupationThreshold) {
        int numOccupiedNeighbors = countOccupiedNeighbors(seat, radiusMax);
        return !seat.isOccupied() && numOccupiedNeighbors == 0 || seat.isOccupied() && numOccupiedNeighbors >= occupationThreshold;
    }

    private int countOccupiedNeighbors(Seat seat, int radiusMax) {
        return Direction.stream()
                .mapToInt(direction -> isNeighborOccupied(seat.getPosition(), direction, radiusMax) ? 1 : 0)
                .sum();
    }

    private boolean isNeighborOccupied(Position position, Direction direction, int radiusMax) {
        if (radiusMax == 0) return false;

        Vector vector = new Vector(direction, 1);
        Position neighborPos = Position.addVector(position, vector);
        if (!isWithinGrid(neighborPos)) return false;

        Tile neighbor = tiles[neighborPos.x][neighborPos.y];
        if (neighbor instanceof Seat) return ((Seat) neighbor).isOccupied();

        return isNeighborOccupied(neighborPos, direction, radiusMax - 1);
    }

    private boolean isWithinGrid(Position pos) {
        return pos.x >= 0 && pos.x < width &&
                pos.y >= 0 && pos.y < height;
    }

    public int countOccupiedSeats() {
        return (int) Arrays.stream(tiles)
                .flatMap(Stream::of)
                .filter(tile -> tile instanceof Seat && ((Seat) tile).isOccupied())
                .count();
    }

    public Grid reset() {
        Arrays.stream(tiles)
                .flatMap(Stream::of)
                .filter(tile -> tile instanceof Seat)
                .forEach(tile -> ((Seat) tile).setOccupied(false));
        return this;
    }

    public void print() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char sign = tiles[x][y] instanceof Floor ? '.' : ((Seat) tiles[x][y]).isOccupied() ? '#' : 'L';
                System.out.print(sign);
            }
            System.out.println();
        }
    }
}
