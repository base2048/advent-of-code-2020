## [AoC 2020 Day 13: Shuttle Search](https://adventofcode.com/2020/day/13)

While part one was solvable in a short time with little effort, part two was a really big challenge. Although it is obvious that all input values are primes, and every high school student knows that the LCM of primes is their product, implementing the whole thing algorithmically with the required bus departure offset was a damn hard nut to crack. Maybe a good idea to read [Pi und die Primzahlen](https://www.springer.com/de/book/9783662628799) by Edmund Weitz.

By default, bus 0 has no offset, but as initial offset parameter `1` is passed which leads to the while-loop for bus 0 ending too early. This must be corrected at the end by `return timestamp + 1`. It is important to note that the `+ 1` at `if (buses.size() == 1) return timestamp + 1` and the `+ 1` in the parameter list of the recursion call `offset + 1` indicate the hardcoded bus departure subsequent offset. An additional passing parameter for this would make the code more difficult to read and was therefore not considered necessary here.

---

![AoC 2020 Day 13](day13--Shuttle_Search.png?raw=true)
