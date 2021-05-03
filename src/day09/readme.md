## [AoC 2020 Day 9: Encoding Error](https://adventofcode.com/2020/day/9)

This challenge was deliberately implemented without any modern Java stuff. No Streams (no SummaryStatistics), no fancy packages (no Arrays.sort) and the most modern data structure that is used is an Array. Only For, While and If - that's how good ole Java goes. Since the parsing of the data does not involve any preprocessing business logic, the parser is exempt from this back-to-the-roots style.

Implementing own *copyOfRange()* and *quickSort()* methods (located in a separate Arrays class and working only with long[]) would of course not be necessary, minimum and maximum can be found much easier. Nevertheless, coding those results in some extra cookies from the Elves.

---

![AoC 2020 Day 9](day09--Encoding_Error.png?raw=true)
