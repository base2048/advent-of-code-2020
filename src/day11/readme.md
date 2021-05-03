## [AoC 2020 Day 11: Seating System](https://adventofcode.com/2020/day/11)

To run that cellular automaton properly, in each round we first identify all seats that have to be toggled, store them in a temporary list and then toggle them all at once.

To identify the neighbors, we iterate over all eight possible neighbor directions by calling the *stream()* method in the *Direction* Enum. With this given direction we generate a vector with the length of one (Santa says the root of 2 is 1) and then add this vector to the current position. Instead of creating a list with neighbors we are looking for, we count the occupied neighbors directly saving time-consuming tinkering with lists.

The method *isNeighborOccupied()* is called for each of the possible directions and searches recursively for the next seat in the given radius *radiusMax*. In case of an infinite search radius, specified with `radiusMax = -1`, each recursive call will decimate radiusMax by one into minus. The base case is therefore that either we find a seat or the neighbor is outside the grid.

The *reset()* method is important for part two to get the seats back to their unoccupied initial state after running part one. Since we call part one procedurally before part two, calling the *reset()* method for part one would not be necessary. The *print()* method has nothing to do with the main business logic, but helps to better stand up to lunatic vacation Elves...

---

![AoC 2020 Day 11](day11--Seating_System.png?raw=true)
