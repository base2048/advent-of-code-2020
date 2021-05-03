package day09;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "35\n" +
            "20\n" +
            "15\n" +
            "25\n" +
            "47\n" +
            "40\n" +
            "62\n" +
            "55\n" +
            "65\n" +
            "95\n" +
            "102\n" +
            "117\n" +
            "150\n" +
            "182\n" +
            "127\n" +
            "219\n" +
            "299\n" +
            "277\n" +
            "309\n" +
            "576";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        challenge.setPreamble(5);
        assertEquals(127, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        challenge.setPreamble(5);
        assertEquals(62, challenge.solvePart2());
    }
}
