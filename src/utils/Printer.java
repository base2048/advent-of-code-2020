package utils;

public class Printer {
    private Printer() {
    }

    public static class CartesianXY {
        private CartesianXY() {
        }

        public static void printRaw(int[][] grid) {
            for (int y = 0; y < grid[0].length; y++) {
                for (int x = 0; x < grid.length; x++) {
                    System.out.print(grid[x][y]);
                }
                System.out.println();
            }
        }

        public static void printSigns(int[][] grid) {
            for (int y = 0; y < grid[0].length; y++) {
                for (int[] ints : grid) {
                    char sign = ints[y] == 1 ? '#' : '.';
                    System.out.print(sign);
                }
                System.out.println();
            }
        }

        public static void printBinary(char[][] grid) {
            for (int y = 0; y < grid[0].length; y++) {
                for (char[] chars : grid) {
                    char sign = chars[y] == '#' ? '1' : '0';
                    System.out.print(sign);
                }
                System.out.println();
            }
        }
    }
}
