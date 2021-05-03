package day08;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "nop +0\n" +
                    "acc +1\n" +
                    "jmp +4\n" +
                    "acc +3\n" +
                    "jmp -3\n" +
                    "acc -99\n" +
                    "acc +1\n" +
                    "jmp -4\n" +
                    "acc +6";

    @Test
    @Order(10)
    void solvePart1() throws Exception {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(5, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() throws Exception {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(8, challenge.solvePart2());
    }
}
