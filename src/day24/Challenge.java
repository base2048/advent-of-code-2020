package day24;

import java.util.*;

public class Challenge {

    private final HexaGrid floor;

    public Challenge(List<String> cardinalTilePaths) {
        this.floor = new HexaGrid();
        this.floor.setTiles(cardinalTilePaths);
    }

    public int solvePart1() {
        return floor.countFlippedTiles();
    }

    public int solvePart2() {
        floor.playTheConway(100);
        return floor.countFlippedTiles();
    }
}
