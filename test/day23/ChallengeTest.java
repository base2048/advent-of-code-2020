package day23;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "389125467";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals("67384529", challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(149245887792L, challenge.solvePart2());
    }
}
