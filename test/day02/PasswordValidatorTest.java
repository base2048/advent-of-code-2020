package day02;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PasswordValidatorTest {

    static File tempFile;

    @BeforeAll
    @Order(1)
    static void setUpAll() throws IOException {
        tempFile = File.createTempFile(PasswordValidatorTest.class.getName(), ".tmp");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("1-3 a: abcde\n" +
                    "1-3 b: cdefg\n" +
                    "2-9 c: ccccccccc");
        }
        tempFile.deleteOnExit();
    }

    @Test
    @Order(10)
    void solvePart1() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(tempFile));
        assertEquals(2, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(tempFile));
        assertEquals(1, challenge.solvePart2());
    }

    @AfterAll
    @Order(1200)
    static void tearDownAll() {
    }
}
