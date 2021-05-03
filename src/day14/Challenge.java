package day14;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Challenge {

    private final List<Mask> masks;

    public Challenge(List<Mask> masks) {
        this.masks = masks;
    }

    public long solvePart1() {
        Map<Long, Long> memory = processMaskOperations(masks, chipV1);
        return memory.values().stream().reduce(0L, (Long::sum));
    }

    public long solvePart2() {
        Map<Long, Long> memory = processMaskOperations(masks, chipV2);
        return memory.values().stream().reduce(0L, (Long::sum));
    }

    private Map<Long, Long> processMaskOperations(List<Mask> masks, Decoder chip) {
        Map<Long, Long> memories = new HashMap<>();

        for (Mask mask : masks)
            for (Memory memory : mask.getMemories())
                memories.putAll(chip.decode(mask, memory));

        return memories;
    }

    Decoder chipV1 = (Mask mask, Memory memory) ->
            Collections.singletonMap(memory.getAddress(), memory.getValue() & mask.getProcessingANDMask() | mask.getProcessingORMask());

    Decoder chipV2 = (Mask mask, Memory memory) ->
            getMemoryAddresses(mask.getMask(), memory.getAddress()).stream()
                    .collect(Collectors.toMap(Function.identity(), $ -> memory.getValue()));

    private List<Long> getMemoryAddresses(String mask, long address) {
        char maskLSB = mask.charAt(mask.length() - 1);

        List<Long> tails = switch (maskLSB) {
            case '0' -> List.of(address & 1);
            case '1' -> List.of(1L);
            case 'X' -> List.of(0L, 1L);
            default -> throw new IllegalStateException();
        };

        if (mask.length() == 1) return tails;
        List<Long> result = new ArrayList<>();

        for (long tail : tails) {
            getMemoryAddresses(mask.substring(0, mask.length() - 1), address >>> 1).stream()
                    .map(head -> head << 1 | tail)
                    .forEach(result::add);
        }
        return result;
    }

    @FunctionalInterface
    private interface Decoder {
        Map<Long, Long> decode(Mask mask, Memory memory);
    }
}

/*
 * address: 101010
 * mask:    X1001X
 *          ------
 * result:  X1101X  =>  0 1101 0
 *                      0 1101 1
 *                      1 1101 0
 *                      1 1101 1
 */
