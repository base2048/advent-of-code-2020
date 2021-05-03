## [AoC 2020 Day 24: Lobby Layout](https://adventofcode.com/2020/day/24)

Towards the end we go among the tilers - thanks to Conway, without messy glue, but cookies always handy.

The interesting thing about this challenge is, that the paths in the instruction consist of single cardinal steps. We decode these into paths of unit vectors. Also, what is new is that the tiles of this 2D cellular automaton have a hexagonal shape, which means that each tile has 6 direct neighbors. The spatial position of a tile is determined in axial coordinates as described in [Hexagonal Grids from Red Blob Games](https://www.redblobgames.com/grids/hexagons/#coordinates-axial).

The rest follows pretty similarly the implementation of the [Minimal4D](../day17#check-this-out-santa-tesseracts-in-a-bag) automaton from day 17. For every tile we lay or turn over, we eat a cookie. Then on December 25, we weigh ourselves with Santa Claus to see who will fly the sleigh next year...

---

![AoC 2020 Day 24](day24--Lobby_Layout.png?raw=true)
