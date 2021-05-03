package day17;

import utils.Timer;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Challenge challenge = new Challenge(Parser.parse(new File("./src/day17/data.txt")));

        Timer.startTimer();
        System.out.print("Result part 1: " + challenge.solvePart1() + " | ");   // 295
        Timer.printTimer(1);

        Timer.startTimer();
        System.out.print("Result part 2: " + challenge.solvePart2() + " | ");   // 1972
        Timer.printTimer(2);

        System.out.printf("%n########################################%n%n");

        Timer.startTimer();
        System.out.print("Result part 2 with Minimal4D: " + Minimal4D.runBootProcess() + " | ");    // 1972
        Timer.printTimer(2);

    }
}
