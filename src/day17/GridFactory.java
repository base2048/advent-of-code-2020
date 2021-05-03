package day17;

import java.util.*;

public class GridFactory {

    private static int dim, width, height, length, depth, xOff, yOff;
    private static String[] data;

    private GridFactory() {
    }

    public static Grid create(String[] inputData, int dimensions, int cycles) {
        data = inputData;
        dim = dimensions;

        width = data[0].length() + cycles * 2;
        height = data.length + cycles * 2;
        length = 1 + cycles * 2;
        depth = 1 + cycles * 2;

        xOff = data[0].length() / 2;
        yOff = data.length / 2;

        Grid grid = switch (dim) {
            case 3 -> new Grid3D(width, height, length, cycles);
            case 4 -> new Grid4D(width, height, length, depth, cycles);
            default -> throw new IllegalStateException();
        };

        grid.insertCube(buildCubes());
        return grid;
    }

    private static List<Cube> buildCubes() {
        List<Cube> cubes = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < length; z++) {
                    int xPos = x - width / 2;
                    int yPos = y - height / 2;
                    int zPos = z - length / 2;

                    if (dim == 3) {
                        boolean isActive = hasActiveCubeFromInputData(xPos, yPos, zPos, 0);
                        cubes.add(new Cube3D(new Position3D(xPos, yPos, zPos), isActive));
                    } else {
                        for (int w = 0; w < depth; w++) {
                            int wPos = w - depth / 2;
                            boolean isActive = hasActiveCubeFromInputData(xPos, yPos, zPos, wPos);
                            cubes.add(new Cube4D(new Position4D(xPos, yPos, zPos, wPos), isActive));
                        }
                    }
                }
            }
        }
        return cubes;
    }

    private static boolean hasActiveCubeFromInputData(int xPos, int yPos, int zPos, int wPos) {
        int x = xPos + xOff, y = yPos + yOff;
        return x >= 0 && x < data[0].length() && y >= 0 && y < data.length &&
                zPos == 0 && wPos == 0 && data[y].charAt(x) == '#';
    }
}
