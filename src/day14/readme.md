## [AoC 2020 Day 14: Docking Data](https://adventofcode.com/2020/day/14)

This challenge is definitely one of the most interesting so far. Part one was done quickly with a little fiddling. To solve the task, a special AND-bitmask and an OR-bitmask are generated from the original mask, which are then applied to the memory address by AND and OR operations.

Part two, on the other hand, was quite challenging. I didn't even try to get by without recursion, which made things a bit more sporty from the start. It took a bit of time to figure out how to correctly reassemble the individual memory addresses bit by bit. Well, time to get a cookie to have something to bit on.

The *getMemoryAddresses()* method for part two can also be programmed without a result array and without an old-fashioned for-loop:

```Java
return tails.stream()
    .flatMap(tail -> getMemoryAddresses(mask.substring(0, mask.length() - 1), address >>> 1).stream()
        .map(head -> head << 1 | tail))
    .collect(Collectors.toList());
```

The code is definitely nicer to look at, has fewer lines, but is a little more complicated to read and above all: takes about three times the runtime. With all the love for good design and modern programming techniques, when it comes down to burning precious lifetime, it stops being fun. With a little effort, it would certainly be possible to integrate the switch into the stream as well - and even before the memory is overflowing, it's already Easter again...

Both part one and part two make use of Functional Interfaces. The Lambda for part one contains all of the business logic, the one for part two contains only some of the control logic. The actual business logic for part two is located in the recursion method *getMemoryAddresses()*.

---

![AoC 2020 Day 14](day14--Docking_Data.png?raw=true)
