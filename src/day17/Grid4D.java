package day17;

import java.util.*;
import java.util.stream.*;

public class Grid4D extends GridBase {

    private final Cube[][][][] cubes;
    private final int depth;
    private final int wCenterOffset;

    public Grid4D(int width, int height, int length, int depth, int cycles) {
        super(width, height, length, cycles);
        this.depth = depth;
        this.wCenterOffset = depth / 2;
        this.cubes = new Cube4D[width][height][length][depth];
    }

    @Override
    public void insertCube(Cube cube) {
        Cube4D c = (Cube4D) cube;
        cubes
                [c.position.x + xCenterOffset]
                [c.position.y + yCenterOffset]
                [c.position.z + zCenterOffset]
                [c.position.w + wCenterOffset] = c;
    }

    @Override
    public void insertCube(List<Cube> cubes) {
        for (Cube cube : cubes)
            insertCube(cube);
    }

    @Override
    public Stream<Cube> streamAllCubes() {
        return Arrays.stream(cubes)
                .flatMap(Stream::of)
                .flatMap(Stream::of)
                .flatMap(Stream::of);
    }

    @Override
    public Stream<Cube> streamNeighbors(Cube cube) {
        Cube4D c = (Cube4D) cube;
        return Direction4D.getAllDirections().stream()
                .map(direction -> {
                    Vector4D vector = new Vector4D(direction, 1);
                    Position4D neighborPos = Position4D.addVector(c.position, vector);

                    if (isWithinGrid(neighborPos)) {
                        int x = neighborPos.x + xCenterOffset;
                        int y = neighborPos.y + yCenterOffset;
                        int z = neighborPos.z + zCenterOffset;
                        int w = neighborPos.w + wCenterOffset;
                        return cubes[x][y][z][w];
                    }
                    return null;
                })
                .filter(Objects::nonNull);
    }

    @Override
    public boolean isWithinGrid(Position pos) {
        Position4D p = (Position4D) pos;
        return p.x + xCenterOffset >= 0 && p.x + xCenterOffset < width &&
                p.y + yCenterOffset >= 0 && p.y + yCenterOffset < height &&
                p.z + zCenterOffset >= 0 && p.z + zCenterOffset < length &&
                p.w + wCenterOffset >= 0 && p.w + wCenterOffset < depth;
    }

    @Override
    public void print() {
        System.out.println("Cookies for everyone");
    }
}
