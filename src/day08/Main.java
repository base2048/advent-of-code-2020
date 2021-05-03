package day08;

import utils.Timer;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        Challenge challenge = new Challenge(Parser.parse(new File("./src/day08/data.txt")));

        Timer.startTimer();
        System.out.print("Result part 1: " + challenge.solvePart1() + " | ");   // 2025
        Timer.printTimer(1);

        Timer.startTimer();
        System.out.print("Result part 2: " + challenge.solvePart2() + " | ");   // 2001
        Timer.printTimer(2);

    }
}
