package day20;

import java.util.*;

public class Transform {

    private Transform() {
    }

    public static int[][] trimEdges(int[][] grid) {
        int[][] result = new int[grid.length - 2][grid.length - 2];

        for (int x = 1; x < grid.length - 1; x++)
            result[x - 1] = Arrays.copyOfRange(grid[x], 1, grid.length - 1);

        return result;
    }

    public static int[][] rotateClockwiseByOne(int[][] grid) {
        int[][] result = new int[grid.length][grid.length];

        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid.length; y++)
                result[x][y] = grid[y][grid.length - x - 1];

        return result;
    }

    public static int[][] flip(int[][] grid, Flip flip) {
        if (flip == Flip.NONE) return grid;
        if (flip == Flip.BOTH) {
            grid = flipHorizontal(grid);
            grid = flipVertical(grid);
            return grid;
        }
        return flip == Flip.HORIZONTAL ? flipHorizontal(grid) : flipVertical(grid);
    }

    private static int[][] flipHorizontal(int[][] grid) {
        int[][] result = new int[grid.length][grid.length];

        for (int x = 0; x < grid.length; x++)
                result[x] = grid[grid.length - x - 1];

        return result;
    }

    private static int[][] flipVertical(int[][] grid) {
        int[][] result = new int[grid.length][grid.length];

        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid.length; y++)
                result[x][y] = grid[x][grid.length - y - 1];

        return result;
    }
}
