## [AoC 2020 Day 20: Jurassic Jigsaw](https://adventofcode.com/2020/day/20)

This is what happens when Santa gets his cookies from Amsterdam.

But let's start from the beginning. Although it is not explicitly mentioned in the given information (and will later prove to be true), we assume that for each edge there is at most only one matching counter edge. We also want to keep in mind that we address the nodes in the grid array the way `grid[x][y]`. We always have to take this into account when we perform operations on the Array like rotation, parsing the edges or whatever. Finally, I would like to mention that this challenge is one of the few where I have added some comments in those places where I think they can help to better understand the code. Even though I usually try to do without comments, this time I felt that variable and method names alone were not always enough.

The first thing we do is to parse the individual tiles from the input data. When creating such a tile, the constructor calls *parseEdges()*, whereupon all eight edges (four front-sided and four back-sided) are read and stored in the *edgeByLocation* map. The tiles are then passed to the *Challenge* constructor, which calls *scrapeEdgeConnections()*. This method scrapes for matching edge connections to other tiles and stores the findings as *Target* objects in *targetByLocation*. Note that each tile has eight edges, four on the front and four on the back, which means that an inner tile has eight found edge connections to its neighbors.

With this, the preparation work is done, and we can start solving the tasks.

Part one is still quite simple. All we have to do is find the four corner tiles. Since the connections have already been determined, we simply take those four tiles that have connections to only two other tiles, thus those tiles where the *targetByLocation* map has a size of 4.

Now we come to part two. This is the challenge Santa came up with when he didn't need any more reindeer to fly...

First we have to put all the pieces of the jigsaw together. That is done by *assembleImage()* and *findAndAlignTiles()*. We search for a corner piece and put it in the *imageTiles* array at position `0,0` in a way that the two outer edges point to the left and to the top. Finding the top outer edge is achieved by *detectTopOuterEdge()*. The realignment of the corner tile as well as all other tiles is handled by the instance method *alignEdgeFromTo()*. As first parameter we pass the location of the edge we want to realign. The second parameter specifies the position which the edge of the first parameter shall take after the realignment.

The alignment is then done by static methods of the *Transform* class. A separate class was chosen because we will use the same methods again later on the *Image* grid. The grid will either be rotated or flipped. Deliberately, the Stream-API was not used, and the logic was implemented classically in loops, even though a horizontal flip, for example, could easily be done by a oneliner with the help of an ArrayDeque like that:

```Java
return Arrays.stream(grid).collect(ArrayDeque::new, ArrayDeque::addFirst, ArrayDeque::addAll).toArray(int[][]::new);
```

I also decided not to do the manipulation within the Array itself. The size of the tiles as well as the final assembled image is quite manageable, O(1) space complexity is not necessary in our case.

*findTarget()* finds the next tile. As parameters, we pass the already *fixedTile* and the *targetLocation* where the next tile shall be located (to the right or bottom). With both of this information we can get the required edge of the fixed tile to which the target tile will be connected and then the *Target* itself.

After all the tiles have been correctly positioned and aligned into the *imageTiles* array, it is time to assemble the image. *assembleImage()* does exactly that by transferring the tiles into a single *Image* grid.

On to the happy monster hunt. This is done by *countSeaMonsters()*. Here we make another presumption, namely that sea monsters show up in only one of the eight possible views of the image. As long as we haven't found any monsters and haven't looked at the picture from all sides, the search will continue. In each viewing cycle *getImageLines()* transcodes the current image view into lines, whereupon *hasSeaMonsterAtPos()* searches for monsters via *matches* at the given positions.

Hallelujah, finally done. For the future we better place a sign: feeding sea monsters and Santa Clauses with cookies is strictly prohibited!

---

![AoC 2020 Day 20](day20--Jurassic_Jigsaw.png?raw=true)
