package day07;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
            "bright white bags contain 1 shiny gold bag.\n" +
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
            "faded blue bags contain no other bags.\n" +
            "dotted black bags contain no other bags.";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(4, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2_test1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(32, challenge.solvePart2());
    }

    @Test
    @Order(30)
    void solvePart2_test2() {
        String input = "shiny gold bags contain 2 dark red bags.\n" +
                "dark red bags contain 2 dark orange bags.\n" +
                "dark orange bags contain 2 dark yellow bags.\n" +
                "dark yellow bags contain 2 dark green bags.\n" +
                "dark green bags contain 2 dark blue bags.\n" +
                "dark blue bags contain 2 dark violet bags.\n" +
                "dark violet bags contain no other bags.";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(126, challenge.solvePart2());
    }

    @Test
    @Order(40)
    void solvePart2_test3() {
        String input = "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
                "faded blue bags contain no other bags.\n" +
                "dotted black bags contain 2 slightly greenish bags.\n" +
                "slightly greenish bags contain no other bags.";

        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(64, challenge.solvePart2());
    }
}
