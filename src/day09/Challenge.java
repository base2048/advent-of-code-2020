package day09;

public class Challenge {

    private int preamble = 25;
    private final long[] dataXMAS;

    public Challenge(long[] dataXMAS) {
        this.dataXMAS = dataXMAS;
    }

    public long solvePart1() {
        for (int i = preamble; i < dataXMAS.length; i++)
            if (!isValidNumber(dataXMAS[i], i)) return dataXMAS[i];

        return 0;
    }

    public long solvePart2() {
        long numToSum = this.solvePart1();
        return findAndProcessContiguousSet(numToSum);
    }

    private boolean isValidNumber(long number, int index) {
        for (int i = index - preamble; i < index - 1; i++)
            for (int j = i + 1; j < index; j++)
                if (dataXMAS[i] + dataXMAS[j] == number) return true;

        return false;
    }

    private long findAndProcessContiguousSet(long numToSum) {
        for (int i = 0; i < dataXMAS.length - 1; i++) {
            long contiguousSetSum = 0;
            int pointer = i;

            while ((contiguousSetSum += dataXMAS[pointer]) < numToSum)
                pointer++;

            if (contiguousSetSum == numToSum) {
                long[] slice = Arrays.copyOfRange(dataXMAS, i, pointer);
                Arrays.sort(slice);
                return slice[0] + slice[slice.length - 1];
            }
        }
        return 0;
    }

    protected void setPreamble(int preamble) {
        this.preamble = preamble;
    }
}
