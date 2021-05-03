package day04;

import utils.Timer;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Challenge challenge = new Challenge(Parser.parse(new File("./src/day04/data.txt")));

        Timer.startTimer();
        System.out.print("Result part 1: " + challenge.solvePart1() + " | ");   // 200
        Timer.printTimer(1);

        Timer.startTimer();
        System.out.print("Result part 2: " + challenge.solvePart2() + " | ");   // 116
        Timer.printTimer(2);

    }
}
