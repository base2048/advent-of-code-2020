package day20;

import java.util.*;
import java.util.stream.*;

public class Image {

    private final List<Tile> tiles;
    private int[][] grid;

    public Image(List<Tile> tiles) {
        this.tiles = tiles;
        this.grid = assembleImage(tiles);
    }

    private int[][] assembleImage(List<Tile> tiles) {
        Tile[][] imageTiles = findAndAlignTiles(tiles);

        int imageTilesLength = imageTiles.length;
        int tileLength = imageTiles[0][0].getGrid().length;

        int[][] grid = new int[imageTilesLength * tileLength][imageTilesLength * tileLength];

        for (int imageTilesX = 0; imageTilesX < imageTilesLength; imageTilesX++)
            for (int imageTilesY = 0; imageTilesY < imageTilesLength; imageTilesY++)

                for (int tileX = 0; tileX < tileLength; tileX++)
                    for (int tileY = 0; tileY < tileLength; tileY++)

                        grid[imageTilesX * tileLength + tileX][imageTilesY * tileLength + tileY] =
                                imageTiles[imageTilesX][imageTilesY].getGrid()[tileX][tileY];

        return grid;
    }

    private Tile[][] findAndAlignTiles(List<Tile> tiles) {
        Tile[][] imageTiles = new Tile[(int) Math.sqrt(tiles.size())][(int) Math.sqrt(tiles.size())];

        for (int y = 0; y < imageTiles.length; y++) {
            if (y == 0) {
                Tile cornerTile = getArbitraryCornerTile().trimEdges();

                cornerTile.alignEdgeFromTo(detectTopOuterEdge(cornerTile), Location.TOP);
                imageTiles[0][y] = cornerTile;
            } else {
                Target target = findTarget(imageTiles[0][y - 1], Location.BOTTOM);
                Tile downTile = target.getTile().trimEdges();

                downTile.alignEdgeFromTo(target.getEdge(), Location.TOP);
                imageTiles[0][y] = downTile;
            }

            for (int x = 1; x < imageTiles.length; x++) {
                Target target = findTarget(imageTiles[x - 1][y], Location.RIGHT);
                Tile rightTile = target.getTile().trimEdges();

                rightTile.alignEdgeFromTo(target.getEdge(), Location.LEFT);
                imageTiles[x][y] = rightTile;
            }
        }
        return imageTiles;
    }

    private Tile getArbitraryCornerTile() {
        return tiles.stream()
                .filter(tile -> tile.getTargetByLocation().size() == 4)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private Location detectTopOuterEdge(Tile cornerTile) {
        List<Location> outerEdges = Location.stream()
                .filter(o -> !cornerTile.getTargetByLocation().containsKey(o))
                .limit(2)   // only take front locations (tile not flipped)
                .collect(Collectors.toList());

        return (outerEdges.get(0).getIndex() + 1) % 4 == outerEdges.get(1).getIndex()
                ? outerEdges.get(1)
                : outerEdges.get(0);
    }

    private Target findTarget(Tile fixedTile, Location targetLocation) {
        /*
         * We must detect the edge of the source tile which the target tile will be connected to. The source tile is
         * fixed yet, the targetLocation tells us the direction where the target tile will be set (to the right or bottom).
         * With both of these information we can get the required edge and then the Target itself.
         */
        int edgeIndex = (targetLocation.getIndex() - fixedTile.getRotation() + 4) % 4 + (fixedTile.isFlipped() ? 4 : 0);
        return fixedTile.getTargetByLocation().get(Location.getByIndex(edgeIndex));
    }

    public int countSeaMonsters(SeaMonster monster) {
        int orientation = 0;
        int monsterCtr = 0;

        while (monsterCtr == 0 && orientation < 8) {
            if (orientation++ == 4)
                grid = Transform.flip(grid, Flip.HORIZONTAL);

            List<String> lines = getImageLines(grid);

            for (int y = 1; y < lines.size() - 1; y++)
                for (int x = 0; x < lines.get(0).length() - monster.getLength(); x++)
                    if (hasSeaMonsterAtPos(monster, lines, x, y))
                        monsterCtr++;

            if (monsterCtr == 0)
                grid = Transform.rotateClockwiseByOne(grid);
        }
        return monsterCtr;
    }

    private List<String> getImageLines(int[][] grid) {
        return IntStream.range(0, grid.length)
                .mapToObj(y -> Arrays.stream(grid).map(col -> String.valueOf(col[y])).collect(Collectors.joining()))
                .collect(Collectors.toList());
    }

    private boolean hasSeaMonsterAtPos(SeaMonster monster, List<String> lines, int x, int y) {
        return lines.get(y).substring(x, x + monster.getLength()).matches(monster.getBodyRGX()) &&
                lines.get(y + 1).substring(x, x + monster.getLength()).matches(monster.getTailRGX()) &&
                lines.get(y - 1).substring(x, x + monster.getLength()).matches(monster.getHeadRGX());
    }

    public int countWaves() {
        return Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();
    }
}
