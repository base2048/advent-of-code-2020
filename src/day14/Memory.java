package day14;

public class Memory {

    private final long address, value;

    public Memory(int address, long value) {
        this.address = address;
        this.value = value;
    }

    public long getAddress() {
        return address;
    }

    public long getValue() {
        return value;
    }
}
