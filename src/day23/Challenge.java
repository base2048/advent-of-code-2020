package day23;

import java.util.stream.IntStream;

import day23.CupList.Cup;

public class Challenge {

    private final CupList cups;
    private Cup firstCup, middleCup, lastCup;

    public Challenge(CupList cups) {
        this.cups = cups;
    }

    public String solvePart1() {
        CupList cups = play(this.cups.clone(), 100);
        String result = cups.toString();

        return result.substring(result.indexOf("1") + 1).concat(result.substring(0, result.indexOf("1")))
                .replaceAll("[\\[\\], ]", "");
    }

    public long solvePart2() {
        CupList cups = play(fillUpTo1Mio(this.cups.clone()), 10_000_000);
        Cup one = cups.getCupByLabel(1);

        return (long) one.nextCup.label * one.nextCup.nextCup.label;
    }

    private CupList play(CupList cups, int rounds) {
        Cup currentCup = cups.getHead();

        for (int i = 0; i < rounds; i++) {
            firstCup = currentCup.nextCup;
            middleCup = firstCup.nextCup;
            lastCup = middleCup.nextCup;

            cups.removeNextThree(currentCup);
            Cup destinationCup = getDestinationCup(currentCup, cups);
            cups.insert(firstCup, lastCup, destinationCup);

            currentCup = currentCup.nextCup;
        }
        return cups;
    }

    private Cup getDestinationCup(Cup currentCup, CupList cups) {
        int destinationCupLabel = currentCup.label - 1 == 0 ? cups.size() : currentCup.label - 1;

        while (destinationCupLabel == firstCup.label || destinationCupLabel == middleCup.label || destinationCupLabel == lastCup.label)
            destinationCupLabel = --destinationCupLabel == 0 ? cups.size() : destinationCupLabel;

        return cups.getCupByLabel(destinationCupLabel);
    }

    private CupList fillUpTo1Mio(CupList cups) {
        IntStream.rangeClosed(cups.size() + 1, 1_000_000).forEach(cups::add);
        return cups;
    }
}
