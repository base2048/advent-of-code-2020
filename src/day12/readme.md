## [AoC 2020 Day 12: Rain Risk](https://adventofcode.com/2020/day/12)

Solution coded in JavaScript for nodeJS.

Although this challenge was coded in JavaScript, I tried to implement the concepts of high-level languages as well as possible. I made sure to use modern JS overall but did not obsessively try to mimic syntax and behavior that JS wasn't made for.

Even though JS is not a true object-oriented language, there is enough syntactic sugar with the new class syntax to make not only the Elves happy. Static and instance methods are used as well as objects and a whole bunch of pseudo getters and setters - and the Factory Method Pattern was also implemented.

The heart of the solution is located in the methods *direction.change()* and *position.rotateAround()*. The calculation could certainly be done mire easily in this case, nevertheless I wanted to implement a version that calculates with the coordinates themselves and does not deal with indices and modulo. Though both methods are almost identical, they are not outsourced to a single function. For a productive use, you will definitely choose a different approach.

---

![AoC 2020 Day 12](day12--Rain_Risk.png?raw=true)
