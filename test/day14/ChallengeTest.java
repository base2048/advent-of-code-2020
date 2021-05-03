package day14;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @Test
    @Order(10)
    void solvePart1() {
        String input = "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X\n" +
                "mem[8] = 11\n" +
                "mem[7] = 101\n" +
                "mem[8] = 0";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(165, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2_test1() {
        String input = "mask = 000000000000000000000000000000X1001X\n" +
                "mem[42] = 100\n" +
                "mask = 00000000000000000000000000000000X0XX\n" +
                "mem[26] = 1";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(208, challenge.solvePart2());
    }

    @Test
    @Order(30)
    void solvePart2_test2() {
        String input = "mask = 1X0\n" +
                "mem[3] = 10";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(20, challenge.solvePart2());
    }
}
