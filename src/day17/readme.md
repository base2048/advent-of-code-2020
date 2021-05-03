## [AoC 2020 Day 17: Conway Cubes](https://adventofcode.com/2020/day/17)

The cellular automata here were constructed similarly to the one in challenge 11. Since we are dealing with a total of two automata, a 3D and a 4D one, two versions had to be developed. Initially I tried to create a more open structure with generics, but this caused a number of additional casts to be made in places, where the code became rather incomprehensible. So I stayed with classic OOP and a Factory Method for the grid.

The grid consists of an Array containing the cubes. As the cube can only be active or inactive, this state could also be stored as a bool in a primitive array. However, we want to give our cubes the chance to evolve and acquire additional properties, maybe one day even intelligent behavior like baking cookies.

As we know from the beginning how many boot-cycles will be run, we also know the maximum size of the Array. Therefore, we initialize an Array with a fixed size and avoid complex rearrangements regarding the size during the boot process. To ensure consistency, the number of cycles is committed to the grid and cannot be changed after instantiation.

The grid has its zero point in the center. The positions of the cubes in space are oriented relative to the center, which means that their coordinates, which are stored in the cube's position object, can take on negative values. Because Arrays are zero-based, an offset is needed to store the cubes in the grid using their position data.

The *getAllDirections()* method of the *Direction* class returns all relative point coordinates next to our current location. Since the next possible point on the direction axes `x, y, z, w` can have a relative value of `-1, 0` and `1`, all combinations are calculated from these main-units `-1, 0, 1`, except for the central point `0, 0, 0, 0`. This results in `3^3 - 1` respectively in `3^4 - 1` directions.

<details>
    <summary>For cookies sake</summary><br/>

In a first version of the *GridFactory* the grid was initially populated with inactive dummy cubes (*buildNeutralCubesToPrefillGrid()*). Subsequently, those cubes were replaced in the grid for which there are cubes from the input data (*buildCubesFromInputData()*). Since you never know when you might need that code again, I'll leave it here for now.

```Java
private static List<Cube> buildNeutralCubesToPrefillGrid() {
    List<Cube> cubes = new ArrayList<>();
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            for (int z = 0; z < length; z++) {
                int xPos = x - width / 2;
                int yPos = y - height / 2;
                int zPos = z - length / 2;

                if (dim == 3) {
                    cubes.add(new Cube3D(new Position3D(xPos, yPos, zPos), false));
                } else {
                    for (int w = 0; w < depth; w++)
                        cubes.add(new Cube4D(new Position4D(xPos, yPos, zPos, w - depth / 2), false));
                }
            }
        }
    }
    return cubes;
}

private static List<Cube> buildCubesFromInputData() {
    List<Cube> cubes = new ArrayList<>();

    for (int x = 0; x < data[0].length(); x++) {
        for (int y = 0; y < data.length; y++) {

            int xPos = x - data[0].length() / 2;
            int yPos = y - data.length / 2;
            int zPos = 0;
            int wPos = 0;
            boolean isActive = data[y].charAt(x) == '#';

            if (dim == 3) cubes.add(new Cube3D(new Position3D(xPos, yPos, zPos), isActive));
            else cubes.add(new Cube4D(new Position4D(xPos, yPos, zPos, wPos), isActive));
        }
    }
    return cubes;
}
```

In the final version these two methods were combined in *buildCubes()*. *isCubeActive()* checks whether a cube from the input data exists for the current position to be filled in the grid and if so, whether it is set to active.

In case of reuse, the *grid.insertCube(buildCubes())* statement in the *create()* method must be replaced with the two statements *grid.insertCube(buildNeutralCubesToPrefillGrid())* and *grid.insertCube(buildCubesFromInputData())*.

</details>

---

#### [Check this out, Santa: tesseracts in a bag!](Minimal4D.java)

Although it was a lot of fun to implement the Conway Cubes in an extensible way, in the end there were 20 files with more than 300 lines of code. To get this down to one single file I thought of a different way to do the task. In [AoC 2015 Day 18](https://github.com/SlevinKT/advent-of-code-2015/tree/main/src/day18) I coded an automaton which stores its status in a primitive int-Array. The two automata here as well as the one of Day 11 work with objects per node. So, why not code an automaton which only keeps the active nodes in a state-bag and does not more and not less than to deliver the required result.

In [Minimal4D](Minimal4D.java) this approach was implemented. The individual nodes are encoded as hash values and stored in the *currentState* bag in case they are active. Each cycle then determines the next state and stores the corresponding nodes in the *nextState* bag.

In *fringeCubes*, those inactive nodes are stored which are adjacent to active nodes. Since the detection radius is `1` and the specifications for a status change require at least one active neighboring node, it is sufficient to detect only those inactive nodes which are in the direct vicinity of the active ones.

The hash value of the nodes is calculated by encoding each coordinate in 6 bit performing a left shift corresponding to its position. This also ensures simple and fast decoding back to their coordinates.

This solution effectively gets by with less than 50 lines of code and is significantly more performant as well.

---

![AoC 2020 Day 17](day17--Conway_Cubes.png?raw=true)
