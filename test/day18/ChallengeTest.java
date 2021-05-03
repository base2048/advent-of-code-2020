package day18;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @Order(10)
    @DisplayName("solvePart1")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {
            "2 * 3 + (4 * 5), 26", "5 + (8 * 3 + 9 + 3 * 4 * 3), 437",
            "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2, 13632",
            "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4)), 12240",
            "4 * 6 + 4 * 6 * 14, 2352"})
    void solvePart1(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart1_test2() {
        String input = "2 * 3 + (4 * 5)\n" +
                "5 + (8 * 3 + 9 + 3 * 4 * 3)\n" +
                "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2\n" +
                "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(26335, challenge.solvePart1());
    }

    @Order(30)
    @DisplayName("solvePart2")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {"1 + (2 * 3) + (4 * (5 + 6)), 51", "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2, 23340"})
    void solvePart2(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart2());
    }
}