package day03;

import java.util.*;

public class Challenge {

    private final List<String> rows;

    public Challenge(List<String> rows) {
        this.rows = rows;
    }

    public long solvePart1() {
        return countTrees(new Vector(3, 1));
    }

    public long solvePart2() {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(1, 1));
        vectors.add(new Vector(3, 1));
        vectors.add(new Vector(5, 1));
        vectors.add(new Vector(7, 1));
        vectors.add(new Vector(1, 2));

        return vectors.stream().mapToLong(this::countTrees).reduce(1, (acc, trees) -> acc * trees);
    }

    public long countTrees(Vector vector) {
        int posX = 0;
        int stepX = vector.x;
        int stepY = vector.y;
        long treeCtr = 0;

        int rowLength = rows.get(0).length();
        for (int i = stepY; i < rows.size(); i += stepY) {
            posX = (posX + stepX) % rowLength;
            treeCtr += rows.get(i).charAt(posX) == '#' ? 1 : 0;
        }
        return treeCtr;
    }

    private static class Vector {
        private final int x, y;

        private Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
