package day01;

import utils.Timer;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Challenge challenge = new Challenge(Parser.parse(new File("./src/day01/data.txt")));

        Timer.startTimer();
        System.out.print("Result part 1: " + challenge.solvePart1() + " | ");   // 437931
        Timer.printTimer(1);

        Timer.startTimer();
        System.out.print("Result part 2: " + challenge.solvePart2() + " | ");   // 157667328
        Timer.printTimer(2);

    }
}
