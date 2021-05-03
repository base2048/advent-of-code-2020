package day11;

public class Challenge {

    private final Grid grid;

    public Challenge(Grid grid) {
        this.grid = grid;
    }

    public int solvePart1() {
        return grid.reset().runOccupation(1, 4).countOccupiedSeats();
    }

    public int solvePart2() {
        final int NO_RADIUS_LIMIT = -1;
        return grid.reset().runOccupation(NO_RADIUS_LIMIT, 5).countOccupiedSeats();
    }
}
