## [AoC 2020 Day 6: Custom Customs](https://adventofcode.com/2020/day/6)

To solve part one, modern Java offers the *distinct()* method, so rather easy to achieve.

The intersection for part two, on the other hand, must be done manually. For self-teaching purposes, I have implemented two different versions: one using a Map (*countDeclarationsEveryoneByMap()*) and, for the cool kids on the block, one using the Stream-API (*countDeclarationsEveryoneByStream()*). As you can see, the time-honored variant without any big fuss is clearly the faster one. But as the saying goes: if you can write it in one line, you don't need a second...

---

![AoC 2020 Day 6](day06--Custom_Customs.png?raw=true)
