package day17;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Minimal4D {

    private static final int cycles = 6;
    private static final File input = new File("./src/day17/data.txt");

    public static int runBootProcess() throws IOException {
        Set<Integer> currentState = parseData();

        for (int i = 0; i < cycles; i++) {
            Set<Integer> nextState = new HashSet<>();
            Map<Integer, Integer> fringeCubes = new HashMap<>();

            for (int activeCube : currentState) {
                Set<Integer> neighbors = getNeighbors(activeCube);
                int activeNeighborsCtr = 0;

                for (int neighbor : neighbors) {
                    if (currentState.contains(neighbor)) activeNeighborsCtr++;
                    else fringeCubes.merge(neighbor, 1, Integer::sum);
                }

                if (activeNeighborsCtr == 2 || activeNeighborsCtr == 3) nextState.add(activeCube);
            }

            fringeCubes.forEach((key, value) -> { if (value == 3) nextState.add(key); });
            currentState = nextState;
        }
        return currentState.size();
    }

    private static Set<Integer> getNeighbors(int cube) {
        int[] units = {-1, 0, 1};
        int[] coords = decodeCubeHash(cube);

        Set<Integer> neighbors = new HashSet<>();
        for (int x : units)
            for (int y : units)
                for (int z : units)
                    for (int w : units)
                        neighbors.add(computeCubeHash(new int[]{coords[0] + x, coords[1] + y, coords[2] + z, coords[3] + w}));

        neighbors.remove(cube);
        return neighbors;
    }

    private static int computeCubeHash(int[] position) {
        return (position[0] << 18) + (position[1] << 12) + (position[2] << 6) + position[3];
    }

    private static int[] decodeCubeHash(int cube) {
        return new int[]{cube >>> 18, cube >>> 12 & 4159, cube >>> 6 & 262207, cube & 16777279};
    }

    private static Set<Integer> parseData() throws IOException {
        String[] data = Files.readAllLines(Minimal4D.input.toPath()).toArray(String[]::new);
        Set<Integer> state = new HashSet<>();

        int offSetX = (64 - data[0].length()) / 2;
        int offSetY = (64 - data.length) / 2;

        if (offSetX < cycles || offSetY < cycles) throw new IllegalStateException("Oida, du brauchst mehr Platz!");

        for (int x = 0; x < data[0].length(); x++)
            for (int y = 0; y < data.length; y++)
                if (data[y].charAt(x) == '#') state.add(computeCubeHash(new int[]{x + offSetX, y + offSetY, 32, 32}));

        return state;
    }
}
