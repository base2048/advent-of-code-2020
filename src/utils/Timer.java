package utils;

public class Timer {

    private static long timer = 0;

    public static void startTimer() {
        timer = System.currentTimeMillis();
    }

    public static void printTimer(int part) {
        System.out.printf("Part %d took %d ms%n", part, System.currentTimeMillis() - timer);
    }
}
