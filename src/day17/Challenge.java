package day17;

public class Challenge {

    private final String[] data;

    public Challenge(String[] inputData) {
        this.data = inputData;
    }

    public int solvePart1() {
        final int dimensions = 3;
        final int cycles = 6;
        final boolean GRID_PRINT = false;

        Grid grid = GridFactory.create(data, dimensions, cycles);
        grid.runBootProcess();

        if (GRID_PRINT) grid.print();

        return grid.countActiveCubes();
    }

    public int solvePart2() {
        final int dimensions = 4;
        final int cycles = 6;

        Grid grid = GridFactory.create(data, dimensions, cycles);
        grid.runBootProcess();

        return grid.countActiveCubes();
    }
}
