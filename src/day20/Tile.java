package day20;

import utils.Printer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Tile {

    private final int id;
    private int[][] grid;
    private int rotation;
    private boolean isFlipped;

    private final Map<Location, String> edgeByLocation;
    private final Map<Location, Target> targetByLocation = new HashMap<>();  // <own edge location, target tile data>

    public Tile(int id, int[][] grid) {
        this.id = id;
        this.grid = grid;
        this.edgeByLocation = parseEdges(this.grid);
    }

    private Map<Location, String> parseEdges(int[][] grid) {
        String top = finishToString(Arrays.stream(grid).mapToInt(col -> col[0]));
        String right = finishToString(Arrays.stream(grid[grid.length - 1], 0, grid.length));

        String flippedBottom = finishToString(Arrays.stream(grid).mapToInt(col -> col[grid.length - 1]));
        String flippedRight = finishToString(Arrays.stream(grid[0], 0, grid.length));

        String flippedTop = reverseString(top);
        String flippedLeft = reverseString(right);

        String bottom = reverseString(flippedBottom);
        String left = reverseString(flippedRight);

        /*
         * List order is important because each index stands for a specific edge. (0 = non-flipped top edge,
         * 7 = flipped left edge [same edge as non-flipped right, but in reverse on the dark side of a square cookie])
         */
        List<String> edges = List.of(top, right, bottom, left, flippedTop, flippedRight, flippedBottom, flippedLeft);
        return Location.stream().collect(Collectors.toMap(Function.identity(), location -> edges.get(location.getIndex())));
    }

    private String finishToString(IntStream stream) {
        return stream.mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public Tile trimEdges() {
        grid = Transform.trimEdges(grid);
        return this;
    }

    public void alignEdgeFromTo(Location grab, Location drop) {
        /*
         * When we build up the image, the edge of the tile we want this tile to connect to is always a front-side edge.
         * Therefore, if we have to connect by an edge on the back-side of this tile, we must flip the tile.
         */
        isFlipped = grab.getIndex() > 3;
        rotation = (drop.getIndex() - grab.getIndex() + 8) % 4;

        switch (rotation) {
            case 0 -> {
                grid = isFlipped ? Transform.flip(grid, Flip.HORIZONTAL) : grid;
            }
            case 1 -> {
                grid = isFlipped ? Transform.flip(grid, Flip.HORIZONTAL) : grid;
                grid = Transform.rotateClockwiseByOne(grid);
            }
            case 2 -> {
                grid = isFlipped
                        ? Transform.flip(grid, Flip.VERTICAL)
                        : Transform.flip(grid, Flip.BOTH);
            }
            case 3 -> {
                if (isFlipped) {
                    grid = Transform.rotateClockwiseByOne(grid);
                    grid = Transform.flip(grid, Flip.HORIZONTAL);
                } else {
                    grid = Transform.rotateClockwiseByOne(grid);
                    grid = Transform.flip(grid, Flip.BOTH);
                }
            }
        }
    }

    public int getId() {
        return id;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getRotation() {
        return rotation;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public Map<Location, String> getEdgeByLocation() {
        return edgeByLocation;
    }

    public Map<Location, Target> getTargetByLocation() {
        return targetByLocation;
    }

    public void printBinary() {
        Printer.CartesianXY.printRaw(grid);
    }

    public void printSigns() {
        Printer.CartesianXY.printSigns(grid);
    }
}
