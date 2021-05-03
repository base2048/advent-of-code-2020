package day11;

import java.io.*;
import java.nio.file.Files;

public class Parser {

    public static Grid parse(String text) {
        return parseTiles(text.split("\n"));
    }

    public static Grid parse(File file) throws IOException {
        return parseTiles(Files.readAllLines(file.toPath()).toArray(String[]::new));
    }

    private static Grid parseTiles(String[] rows) {
        int width = rows[0].length();
        int height = rows.length;
        Tile[][] tiles = new Tile[width][height];

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                tiles[x][y] = buildTile(rows[y].charAt(x), x, y);

        return new Grid(tiles);
    }

    private static Tile buildTile(char type, int x, int y) {
        Position position = new Position(x, y);
        return switch (type) {
            case 'L' -> new Seat(position);
            case '.' -> new Floor(position);
            default -> throw new IllegalArgumentException();
        };
    }
}
