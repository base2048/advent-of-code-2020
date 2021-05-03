## [AoC 2020 Day 5: Binary Boarding](https://adventofcode.com/2020/day/5)

After decoding the boarding pass directives to a unique seat ID (related logic is implemented in the *Seat* class), you realize that the ID is beautifully hidden completely as a binary number ;). Maybe this could have been figured out earlier - however, purely for nostalgic reasons here the legacy code:

```Java
private int decodePassCodeToSeatId(String code) {
    return decodeDirectionToNumber(code.substring(0, 7), 'B') * 8 + decodeDirectionToNumber(code.substring(7), 'R');
}

private int decodeDirectionToNumber(String code, char up) {
    return IntStream.range(0, code.length())
            .reduce(0, (acc, i) -> code.charAt(i) == up ? acc + (int) Math.pow(2, code.length() - i - 1) : acc);
}
```

---

![AoC 2020 Day 5](day05--Binary_Boarding.png?raw=true)
