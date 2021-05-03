package day14;

import java.util.*;

public class Mask {

    private final String mask;
    private final List<Memory> memories;

    public Mask(String mask) {
        this.mask = mask;
        this.memories = new ArrayList<>();
    }

    public String getMask() {
        return mask;
    }

    public List<Memory> getMemories() {
        return memories;
    }

    public long getProcessingANDMask() {
        return Long.parseLong(mask.replaceAll("X", "1"), 2);
    }

    public long getProcessingORMask() {
        return Long.parseLong(mask.replaceAll("X", "0"), 2);
    }
}
