package day25;

public class Challenge {

    private final int cardsPublicKey;
    private final int doorsPublicKey;
    private final int subjectNumber;
    private final int modulus;

    public Challenge(int[] keys) {
        this.cardsPublicKey = keys[0];
        this.doorsPublicKey = keys[1];
        this.subjectNumber = 7;
        this.modulus = 20201227;
    }

    public long solvePart1() {
        int value = 1;
        int cardsLoopSize = 0;
        long encryptionKey = 1;

        while (value != cardsPublicKey) {
            value = (value * subjectNumber) % modulus;
            cardsLoopSize++;
        }

        for (int i = 0; i < cardsLoopSize; i++)
            encryptionKey = (encryptionKey * doorsPublicKey) % modulus;

        return encryptionKey;
    }

    public String solvePart2() {
        return "Enjoying soft ice and cookies in Santa's sleigh...";
    }
}
