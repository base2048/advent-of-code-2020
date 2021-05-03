## [AoC 2020 Day 8: Handheld Halting](https://adventofcode.com/2020/day/8)

I like this way of writing code a lot. Everything is clearly structured and logically implemented down to a few rules - you can almost feel the first programmers' excitement when they got their code run.

Part one terminates execution as soon as an instruction is called twice. Part two does the same, but then modifies the code repeatedly until the program finishes correctly with exit-code 0. To achieve this, the *modifyCode()* method first resets all instruction counters, then undoes the previous modification, and then searches for and modifies the next instruction.

---

![AoC 2020 Day 8](day08--Handheld_Halting.png?raw=true)
