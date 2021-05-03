package day05;

public class Seat {

    private final String passCode;
    private final int id;

    public Seat(String passCode) {
        this.passCode = passCode;
        this.id = decodePassCodeToSeatId(passCode);
    }

    protected static int decodePassCodeToSeatId(String code) {
        return Integer.parseInt(code.replaceAll("[FL]", "0").replaceAll("[BR]", "1"), 2);
    }

    public int getId() {
        return id;
    }
}
