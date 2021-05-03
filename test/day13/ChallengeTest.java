package day13;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "939\n" +
            "7,13,x,x,59,x,31,19";
    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(295, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(1068781, challenge.solvePart2());
    }

    @Order(30)
    @DisplayName("solvePart2_shorts")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {
            "'939\n3,5' : 9",
            "'939\n3,5,x,7' : 39",
            "'939\n3,x,x,x,5' : 6",
            "'939\n3,x,5' : 3"}, delimiter = ':')
    void solvePart2_short(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart2());
    }
}
