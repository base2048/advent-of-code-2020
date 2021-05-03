package day22;

import java.util.*;
import java.util.stream.*;

public class Challenge {

    private final ArrayDeque<Integer> cardsPlayer1;
    private final ArrayDeque<Integer> cardsPlayer2;

    public Challenge(Parser.Dataset data) {
        this.cardsPlayer1 = data.cardsPlayer1;
        this.cardsPlayer2 = data.cardsPlayer2;
    }

    public int solvePart1() {
        ArrayDeque<Integer> cardsPlayer1 = this.cardsPlayer1.clone();
        ArrayDeque<Integer> cardsPlayer2 = this.cardsPlayer2.clone();

        Player winner = play(cardsPlayer1, cardsPlayer2, false);
        return calculateWinningScore(winner == Player.ONE ? cardsPlayer1 : cardsPlayer2);
    }

    public int solvePart2() {
        ArrayDeque<Integer> cardsPlayer1 = this.cardsPlayer1.clone();
        ArrayDeque<Integer> cardsPlayer2 = this.cardsPlayer2.clone();

        Player winner = play(cardsPlayer1, cardsPlayer2, true);
        return calculateWinningScore(winner == Player.ONE ? cardsPlayer1 : cardsPlayer2);
    }

    private Player play(ArrayDeque<Integer> cardsPlayer1, ArrayDeque<Integer> cardsPlayer2, boolean isRecursive) {
        Set<String> history = new HashSet<>();
        Player winnerOfTheRound;

        while (!cardsPlayer1.isEmpty() && !cardsPlayer2.isEmpty()) {
            String snapshot = cardsPlayer1.toString() + cardsPlayer2.toString();
            if (!history.add(snapshot)) return Player.ONE;

            int cardPlayer1 = cardsPlayer1.removeFirst();
            int cardPlayer2 = cardsPlayer2.removeFirst();

            if (isRecursive && cardPlayer1 <= cardsPlayer1.size() && cardPlayer2 <= cardsPlayer2.size()) {
                winnerOfTheRound = play(copySubDeque(cardsPlayer1, 0, cardPlayer1),
                        copySubDeque(cardsPlayer2, 0, cardPlayer2), true);
            } else {
                winnerOfTheRound = cardPlayer1 > cardPlayer2 ? Player.ONE : Player.TWO;
            }

            if (winnerOfTheRound == Player.ONE) cardsPlayer1.addAll(List.of(cardPlayer1, cardPlayer2));
            else cardsPlayer2.addAll(List.of(cardPlayer2, cardPlayer1));
        }

        return cardsPlayer1.size() > 0 ? Player.ONE : Player.TWO;
    }

    private ArrayDeque<Integer> copySubDeque(ArrayDeque<Integer> source, int startInclusive, int endExclusive) {
        return source.stream()
                .skip(startInclusive)
                .limit(endExclusive - startInclusive)
                .collect(ArrayDeque::new, ArrayDeque::addLast, ArrayDeque::addAll);
    }

    private int calculateWinningScore(ArrayDeque<Integer> cards) {
        return IntStream.rangeClosed(1, cards.size()).reduce(0, (acc, worth) -> acc + cards.removeLast() * worth);
    }
}
