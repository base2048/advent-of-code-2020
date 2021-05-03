# [Advent of Code 2020](https://adventofcode.com/2020)

|   # | Challenge                                                       | Solution                           | Keywords                              |
|:---:|:---------------------------------------------------------------:|:----------------------------------:|:--------------------------------------|
|   1 | [Report Repair](https://adventofcode.com/2020/day/1)            | [Solution](src/day01)              | Recursion                             |
|   2 | [Password Philosophy](https://adventofcode.com/2020/day/2)      | [Solution](src/day02)              | Factory Method Pattern                |
|   3 | [Toboggan Trajectory](https://adventofcode.com/2020/day/3)      | [Solution](src/day03)              |                                       |
|   4 | [Passport Processing](https://adventofcode.com/2020/day/4)      | [Solution](src/day04)              | Predicates                            |
|   5 | [Binary Boarding](https://adventofcode.com/2020/day/5)          | [Solution](src/day05)              | Binary Maths                          |
|   6 | [Custom Customs](https://adventofcode.com/2020/day/6)           | [Solution](src/day06)              | Distinction, Intersection             |
|   7 | [Handy Haversacks](https://adventofcode.com/2020/day/7)         | [Solution](src/day07)              | Recursion with Map and Set            |
|   8 | [Handheld Halting](https://adventofcode.com/2020/day/8)         | [Solution](src/day08)              | Turing Machine                        |
|   9 | [Encoding Error](https://adventofcode.com/2020/day/9)           | [Solution](src/day09)              | Plain Ole Java                        |
|  10 | [Adapter Array](https://adventofcode.com/2020/day/10)           | [Solution](src/day10)              | Recursion, Cache                      |
|  11 | [Seating System](https://adventofcode.com/2020/day/11)          | [Solution](src/day11)              | 2D Cellular Automaton, Recursion      |
|  12 | [Rain Risk](https://adventofcode.com/2020/day/12)               | [Solution](src/day12)              | JavaScript, Factory Method            |
|  13 | [Shuttle Search](https://adventofcode.com/2020/day/13)          | [Solution](src/day13)              | Primes, Recursion                     |
|  14 | [Docking Data](https://adventofcode.com/2020/day/14)            | [Solution](src/day14)              | Bitmask, FI, Recursion                |
|  15 | [Rambunctious Recitation](https://adventofcode.com/2020/day/15) | [Solution](src/day15)              |                                       |
|  16 | [Ticket Translation](https://adventofcode.com/2020/day/16)      | [Solution](src/day16)              | Recursion, Streams                    |
|  17 | [Conway Cubes](https://adventofcode.com/2020/day/17)            | [Solution](src/day17)              | 4D Cellular Automaton, Factory Method |
|  18 | [Operation Order](https://adventofcode.com/2020/day/18)         | [Solution](src/day18)              |                                       |
|  19 | [Monster Messages](https://adventofcode.com/2020/day/19)        | [Solution](src/day19)              |                                       |
|  20 | [Jurassic Jigsaw](https://adventofcode.com/2020/day/20)         | [Solution](src/day20)              | Santa goes bananas...                 |
|  21 | [Allergen Assessment](https://adventofcode.com/2020/day/21)     | [Solution](src/day21)              | Intersecting Collector, Recursion     |
|  22 | [Crab Combat](https://adventofcode.com/2020/day/22)             | [Solution](src/day22)              |                                       |
|  23 | [Crab Cups](https://adventofcode.com/2020/day/23)               | [Solution](src/day23)              | Circular Linked List with Iterator    |
|  24 | [Lobby Layout](https://adventofcode.com/2020/day/24)            | [Solution](src/day24)              | 2D Cellular Automaton                 |
|  25 | [Combo Breaker](https://adventofcode.com/2020/day/25)           | [Solution](src/day25)              |                                       |

All challenges were implemented in Java, except for day 12, which was done in JavaScript. Outstanding challenges can be found on [Day 14](src/day14), [Day 17](src/day17) and [Day 20](src/day20). [Day 12](src/day12) could also be mentioned here for its implementation in JavaScript.

A click on the challenge link directly leads to the corresponding challenge page on [Advent of Code](https://adventofcode.com). As long as part one of the daily challenge has not been completed successfully, part two is not visible. Therefore, a screenshot with the complete challenge information was added to the source folder of the day. A click on *Solution* leads straight to the daily folder.

The challenges are all structured in the same way. The *Main* file is the entry point. In it, an instance of *Challenge* is created. The input data, which can be found in *data.txt*, is passed to the challenge constructor by means of *Parser*. The parser usually prepares the input data in a boilerplate manner, but sometimes, as for example on [Day 04](src/day04) or [Day 16](src/day16), interesting logic can already be found here. The actual business logic is then located in *Challenge* and further classes.

Code blocks in the *readme* files did not make it into the final versions. Usually these are alternate implementations, but I consider the final ones to be nicer, more modern or simply faster. Please think of this code as additional information only.

An explicit check for accuracy of the input data as well as of the passed parameter values within the implementation has been omitted in the interest of clarity and readability. We assume that both the input data and the passed values are correct. Of course, I have checked the code and the results and can confirm that everything is fine.

---

![AoC 2020 Tour](src/tour.png?raw=true)
