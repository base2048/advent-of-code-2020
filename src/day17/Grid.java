package day17;

import java.util.*;
import java.util.stream.Stream;

public interface Grid {

    void insertCube(Cube cube);

    void insertCube(List<Cube> cubes);

    Stream<Cube> streamAllCubes();

    Stream<Cube> streamNeighbors(Cube cube);

    boolean isWithinGrid(Position pos);

    void runBootProcess();

    int countActiveCubes();

    void print();
}
