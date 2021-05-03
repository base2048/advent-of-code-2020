package day20;

import org.junit.jupiter.api.*;
import utils.Printer;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Since we parse the grid into the array in an x/y manner (grid[x][y])
 * and the methods reads out the x and y axes accordingly, we have to
 * run the test input through the parser or take this into the result.
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "Tile 2311:\n" +
            "..##.#..#.\n" +
            "##..#.....\n" +
            "#...##..#.\n" +
            "####.#...#\n" +
            "##.##.###.\n" +
            "##...#.###\n" +
            ".#.#.#..##\n" +
            "..#....#..\n" +
            "###...#.#.\n" +
            "..###..###\n" +
            "\n" +
            "Tile 1951:\n" +
            "#.##...##.\n" +
            "#.####...#\n" +
            ".....#..##\n" +
            "#...######\n" +
            ".##.#....#\n" +
            ".###.#####\n" +
            "###.##.##.\n" +
            ".###....#.\n" +
            "..#.#..#.#\n" +
            "#...##.#..\n" +
            "\n" +
            "Tile 1171:\n" +
            "####...##.\n" +
            "#..##.#..#\n" +
            "##.#..#.#.\n" +
            ".###.####.\n" +
            "..###.####\n" +
            ".##....##.\n" +
            ".#...####.\n" +
            "#.##.####.\n" +
            "####..#...\n" +
            ".....##...\n" +
            "\n" +
            "Tile 1427:\n" +
            "###.##.#..\n" +
            ".#..#.##..\n" +
            ".#.##.#..#\n" +
            "#.#.#.##.#\n" +
            "....#...##\n" +
            "...##..##.\n" +
            "...#.#####\n" +
            ".#.####.#.\n" +
            "..#..###.#\n" +
            "..##.#..#.\n" +
            "\n" +
            "Tile 1489:\n" +
            "##.#.#....\n" +
            "..##...#..\n" +
            ".##..##...\n" +
            "..#...#...\n" +
            "#####...#.\n" +
            "#..#.#.#.#\n" +
            "...#.#.#..\n" +
            "##.#...##.\n" +
            "..##.##.##\n" +
            "###.##.#..\n" +
            "\n" +
            "Tile 2473:\n" +
            "#....####.\n" +
            "#..#.##...\n" +
            "#.##..#...\n" +
            "######.#.#\n" +
            ".#...#.#.#\n" +
            ".#########\n" +
            ".###.#..#.\n" +
            "########.#\n" +
            "##...##.#.\n" +
            "..###.#.#.\n" +
            "\n" +
            "Tile 2971:\n" +
            "..#.#....#\n" +
            "#...###...\n" +
            "#.#.###...\n" +
            "##.##..#..\n" +
            ".#####..##\n" +
            ".#..####.#\n" +
            "#..#.#..#.\n" +
            "..####.###\n" +
            "..#.#.###.\n" +
            "...#.#.#.#\n" +
            "\n" +
            "Tile 2729:\n" +
            "...#.#.#.#\n" +
            "####.#....\n" +
            "..#.#.....\n" +
            "....#..#.#\n" +
            ".##..##.#.\n" +
            ".#.####...\n" +
            "####.#.#..\n" +
            "##.####...\n" +
            "##..#.##..\n" +
            "#.##...##.\n" +
            "\n" +
            "Tile 3079:\n" +
            "#.#.#####.\n" +
            ".#..######\n" +
            "..#.......\n" +
            "######....\n" +
            "####.#..#.\n" +
            ".#...#.##.\n" +
            "#.#####.##\n" +
            "..#.###...\n" +
            "..#.......\n" +
            "..#.###...";

    final File file = new File("./test/day20/testData.txt");

    @Test
    @Order(10)
    void solvePart1() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(file));
        assertEquals(20899048083289L, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(file));
        assertEquals(273, challenge.solvePart2());
    }

    @Test
    @Order(30)
    void trimEdges() {
        int[][] grid = new int[][]{
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}
        };
        int[][] expectedResult = new int[][]{
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 1}
        };
        Printer.CartesianXY.printSigns(grid);
        System.out.println();
        Printer.CartesianXY.printRaw(grid);
        assertArrayEquals(expectedResult, Transform.trimEdges(grid));
    }

    @Test
    @Order(40)
    void rotateClockwiseByOne_test1() {
        int[][] grid = new int[][]{
                {1, 1, 0},
                {1, 0, 0},
                {0, 1, 0}
        };
        int[][] expectedResult = new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {1, 1, 0}
        };
        assertArrayEquals(expectedResult, Transform.rotateClockwiseByOne(grid));
    }

    @Test
    @Order(50)
    void rotateClockwiseByOne_test2() {
        int[][] grid = new int[][]{
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 1}
        };
        int[][] expectedResult = new int[][]{
                {1, 0, 0, 1},
                {0, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };
        assertArrayEquals(expectedResult, Transform.rotateClockwiseByOne(grid));
    }

    @Test
    @Order(60)
    void flipHorizontal() {
        int[][] grid = new int[][]{
                {1, 1, 0},
                {1, 0, 0},
                {0, 1, 0}
        };
        int[][] expectedResult = new int[][]{
                {0, 1, 0},
                {1, 0, 0},
                {1, 1, 0}
        };
        assertArrayEquals(expectedResult, Transform.flip(grid, Flip.HORIZONTAL));
    }

    @Test
    @Order(70)
    void flipVertical() {
        int[][] grid = new int[][]{
                {1, 1, 0},
                {1, 0, 0},
                {0, 1, 0}
        };
        int[][] expectedResult = new int[][]{
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 0}
        };
        assertArrayEquals(expectedResult, Transform.flip(grid, Flip.VERTICAL));
    }

    @Test
    @Order(80)
    void printBinary() {
        String tile = "Tile 0000:\n" +
                "##.#\n" +
                "#...\n" +
                ".###\n" +
                ".#.#";

        System.out.println();
        Parser.parse(tile).get(0).printBinary();
    }

    @Test
    @Order(90)
    void printSigns() {
        String tile = "Tile 0000:\n" +
                "##.#\n" +
                "#...\n" +
                ".###\n" +
                ".#.#";

        System.out.println();
        Parser.parse(tile).get(0).printSigns();
    }
}
