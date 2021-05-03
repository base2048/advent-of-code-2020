package day15;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @Order(10)
    @DisplayName("solvePart1")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {"0,3,6 : 436", "3,1,2 : 1836", "1,2,3 : 27"}, delimiter = ':')
    void solvePart1(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        String input = "0,3,6";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(175594, challenge.solvePart2());
    }
}
