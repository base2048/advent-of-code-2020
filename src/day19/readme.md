## [AoC 2020 Day 19: Monster Messages](https://adventofcode.com/2020/day/19)

Part one is pretty straightforward replacing all the numbers until they are replaced with the initial values according to the rules.

Part two, on the other hand, is a bit trickier. Since we end up in a loop, we have to define a termination condition: we replace the looping rules with themselves until we don't get any additional matches.

As just mentioned, replacing rule 8: `42` with `42 | 42 8` and rule 11: `42 31` with `42 31 | 42 11 31` will end up in infinite loops. In order to still achieve a solution, we can run through the following thought: let us rethink both rules as Regex, and we get for rule 8: `42 | 42 8` the Regex `42+` and for rule 11: `42 31 | 42 11 31` the Regex `42{i} 31{i}` where the `i` is the count variable of the current loop we need to build the Regex. The result is something like this: `(42+ ((42{1} 31{1}) | (42{2} 31{2}) ... (42{n} 31{n})))` where `n` is the maximum loop count we need to cover all messages.

We start building our Regex with only one loop. Then we check the number of matches that were found and store them in a cache. The next Regex is built with an additional loop and so on until *matchCount* does not change anymore. This is the point when all messages are covered by our final Regex.

---

![AoC 2020 Day 19](day19--Monster_Messages.png?raw=true)
