package day17;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String text = ".#.\n" +
            "..#\n" +
            "###";

    final File file = new File("test/day17/testData.txt");

    @Test
    @Order(10)
    void solvePart1_text() {
        Challenge challenge = new Challenge(Parser.parse(text));
        assertEquals(112, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2_text() {
        Challenge challenge = new Challenge(Parser.parse(text));
        assertEquals(848, challenge.solvePart2());
    }

    @Test
    @Order(30)
    void solvePart1_file() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(file));
        assertEquals(317, challenge.solvePart1());
    }

    @Test
    @Order(40)
    void solvePart2_file() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(file));
        assertEquals(1692, challenge.solvePart2());
    }

    @Test
    @Order(50)
    void Minimal4D() throws IOException {
        assertEquals(1972, Minimal4D.runBootProcess());
    }
}
