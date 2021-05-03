package day17;

import java.util.*;
import java.util.stream.*;

public class Grid3D extends GridBase {

    private final Cube[][][] cubes;

    public Grid3D(int width, int height, int length, int cycles) {
        super(width, height, length, cycles);
        this.cubes = new Cube3D[width][height][length];
    }

    @Override
    public void insertCube(Cube cube) {
        Cube3D c = (Cube3D) cube;
        cubes
                [c.position.x + xCenterOffset]
                [c.position.y + yCenterOffset]
                [c.position.z + zCenterOffset] = c;
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
                .flatMap(Stream::of);
    }

    @Override
    public Stream<Cube> streamNeighbors(Cube cube) {
        Cube3D c = (Cube3D) cube;
        return Direction3D.getAllDirections().stream()
                .map(direction -> {
                    Vector3D vector = new Vector3D(direction, 1);
                    Position3D neighborPos = Position3D.addVector(c.position, vector);

                    if (isWithinGrid(neighborPos)) {
                        int x = neighborPos.x + xCenterOffset;
                        int y = neighborPos.y + yCenterOffset;
                        int z = neighborPos.z + zCenterOffset;
                        return cubes[x][y][z];
                    }
                    return null;
                })
                .filter(Objects::nonNull);
    }

    @Override
    public boolean isWithinGrid(Position pos) {
        Position3D p = (Position3D) pos;
        return p.x + xCenterOffset >= 0 && p.x + xCenterOffset < width &&
                p.y + yCenterOffset >= 0 && p.y + yCenterOffset < height &&
                p.z + zCenterOffset >= 0 && p.z + zCenterOffset < length;
    }

    @Override
    public void print() {
        for (int z = 0; z < length; z++) {
            System.out.println("z = " + ((Cube3D) cubes[cubes.length / 2][cubes[0].length / 2][z]).position.z);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    char sign = cubes[x][y][z].isActive() ? '#' : '.';
                    System.out.print(sign);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
