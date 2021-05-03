package day01;

import java.util.List;

public class Challenge {

    private final List<Integer> numbers;

    public Challenge(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int solvePart1() {
        return getProduct(numbers, 2, 2020);
    }

    public int solvePart2() {
        return getProduct(numbers, 3, 2020);
    }

    private int getProduct(List<Integer> numbers, int remainingNumbersToSum, int remainingSum) {
        if (numbers.isEmpty() || remainingNumbersToSum == 0) return 0;

        int numbersHead = numbers.get(0);
        if (numbersHead == remainingSum && remainingNumbersToSum == 1) return numbersHead;

        List<Integer> numbersTail = numbers.subList(1, numbers.size());
        int result = numbersHead * getProduct(numbersTail, remainingNumbersToSum - 1, remainingSum - numbersHead);
        if (result > 0) return result;

        return getProduct(numbersTail, remainingNumbersToSum, remainingSum);
    }
}
