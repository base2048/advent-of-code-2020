package day20;

import java.util.*;

public class Challenge {

    private final List<Tile> tiles;

    public Challenge(List<Tile> tiles) {
        this.tiles = scrapeEdgeConnections(tiles);
    }

    public long solvePart1() {
        /*
         * Corner tiles only have connections to 2 adjacent tiles.
         * All connections are counted twice (avers and flipped).
         * Therefore, we search for tiles with 4 entries in targetByLocation.
         */
        return tiles.stream()
                .filter(tile -> tile.getTargetByLocation().size() == 4)
                .mapToLong(Tile::getId)
                .reduce(1, (acc, id) -> acc * id);
    }

    public int solvePart2() {
        Image image = new Image(tiles);
        SeaMonster monster = new SeaMonster();

        int monsterCtr = image.countSeaMonsters(monster);
        int totalMonsterPieces = monster.countPieces() * monsterCtr;
        int waves = image.countWaves();

        return waves - totalMonsterPieces;
    }

    private List<Tile> scrapeEdgeConnections(List<Tile> tiles) {
        for (int i = 0; i < tiles.size() - 1; i++)
            for (int j = i + 1; j < tiles.size(); j++)

                for (Map.Entry<Location, String> edge1 : tiles.get(i).getEdgeByLocation().entrySet())
                    for (Map.Entry<Location, String> edge2 : tiles.get(j).getEdgeByLocation().entrySet())

                        if (edge1.getValue().equals(reverseString(edge2.getValue()))) {
                            tiles.get(i).getTargetByLocation().put(edge1.getKey(), new Target(tiles.get(j), edge2.getKey()));
                            tiles.get(j).getTargetByLocation().put(edge2.getKey(), new Target(tiles.get(i), edge1.getKey()));
                        }

        return tiles;
    }

    private String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
