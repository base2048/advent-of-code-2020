package day03;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "..##.......\n" +
            "#...#...#..\n" +
            ".#....#..#.\n" +
            "..#.#...#.#\n" +
            ".#...##..#.\n" +
            "..#.##.....\n" +
            ".#.#.#....#\n" +
            ".#........#\n" +
            "#.##...#...\n" +
            "#...##....#\n" +
            ".#..#...#.#";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(7, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(336, challenge.solvePart2());
    }
}
