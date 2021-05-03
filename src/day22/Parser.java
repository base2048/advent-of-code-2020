package day22;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Parser {

    public static Dataset parse(String text) {
        String[] players = text.split("\n\n");
        return parseData(players);
    }

    public static Dataset parse(File file) throws IOException {
        String[] players = Files.readString(file.toPath()).replaceAll("\r", "").split("\n\n");
        return parseData(players);
    }

    private static Dataset parseData(String[] players) {
        return new Dataset(parseCards(players[0]), parseCards(players[1]));
    }

    private static ArrayDeque<Integer> parseCards(String cards) {
        return Arrays.stream(cards.split("\n"))
                .skip(1)
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::addLast, ArrayDeque::addAll);
    }

    protected static class Dataset {
        protected ArrayDeque<Integer> cardsPlayer1;
        protected ArrayDeque<Integer> cardsPlayer2;

        private Dataset(ArrayDeque<Integer> cardsPlayer1, ArrayDeque<Integer> cardsPlayer2) {
            this.cardsPlayer1 = cardsPlayer1;
            this.cardsPlayer2 = cardsPlayer2;
        }
    }
}
