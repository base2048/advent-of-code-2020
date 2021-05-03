package day01;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "1721\n" +
            "979\n" +
            "366\n" +
            "299\n" +
            "675\n" +
            "1456";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(514579, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(241861950, challenge.solvePart2());
    }
}
