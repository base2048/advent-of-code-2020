package day25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @Test
    void solvePart1() {
        String input = "5764801\n" +
                "17807724";

        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(14897079,challenge.solvePart1());
    }
}
