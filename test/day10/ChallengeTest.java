package day10;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final static String input1 = "16\n" +
            "10\n" +
            "15\n" +
            "5\n" +
            "1\n" +
            "11\n" +
            "7\n" +
            "19\n" +
            "6\n" +
            "12\n" +
            "4";

    final static String input2 = "28\n" +
            "33\n" +
            "18\n" +
            "42\n" +
            "31\n" +
            "14\n" +
            "46\n" +
            "20\n" +
            "48\n" +
            "47\n" +
            "24\n" +
            "23\n" +
            "49\n" +
            "45\n" +
            "19\n" +
            "38\n" +
            "39\n" +
            "11\n" +
            "1\n" +
            "32\n" +
            "25\n" +
            "35\n" +
            "8\n" +
            "17\n" +
            "7\n" +
            "9\n" +
            "4\n" +
            "2\n" +
            "34\n" +
            "10\n" +
            "3";

    @Order(10)
    @DisplayName("solvePart1")
    @ParameterizedTest(name = "{index}")
    @MethodSource("solvePart1Provider")
    void solvePart1(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart1());
    }

    static Stream<Arguments> solvePart1Provider() {
        return Stream.of(
                Arguments.of(input1, 35),
                Arguments.of(input2, 220)
        );
    }

    @Order(20)
    @DisplayName("solvePart2")
    @ParameterizedTest(name = "{index}")
    @MethodSource("solvePart2Provider")
    void solvePart2(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart2());
    }

    static Stream<Arguments> solvePart2Provider() {
        return Stream.of(
                Arguments.of(input1, 8),
                Arguments.of(input2, 19208)
        );
    }
}
