## [AoC 2020 Day 15: Rambunctious Recitation](https://adventofcode.com/2020/day/15)

Nothing earth-shattering, everything in the green zone. It is probably worth noting that somehow the last starting number must be shifted into the loop without writing it into the index cache before. The chosen variant how this is done is the reason why there are additional `-1`s in the parameter lists of the for-loops.

For part one a Map was chosen as index cache. Due to the bad runtime in part two (around 5 seconds), the Map was replaced by an Array. The index position of the Array stands for the spoken number, the value gives the last mention of this number. That's all, time for more cookies.

---

![AoC 2020 Day 15](day15--Rambunctious_Recitation.png?raw=true)
