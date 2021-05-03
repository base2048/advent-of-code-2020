package day20;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern idPAT = Pattern.compile("\\d+");
    private static Matcher matcher;

    public static List<Tile> parse(String text) {
        return Arrays.stream(text.split("\n\n")).map(Parser::buildTile).collect(Collectors.toList());
    }

    public static List<Tile> parse(File file) throws IOException {
        return Arrays.stream(Files.readString(file.toPath(), StandardCharsets.UTF_8).replaceAll("\r", "").split("\n\n"))
                .map(Parser::buildTile).collect(Collectors.toList());
    }

    private static Tile buildTile(String tile) {
        String[] data = tile.split("\n");

        (matcher = idPAT.matcher(data[0])).find();
        int id = Integer.parseInt(matcher.group());

        int[][] grid = new int[data[1].length()][data.length - 1];
        for (int y = 0; y < grid.length; y++)
            for (int x = 0; x < grid[0].length; x++)
                grid[x][y] = data[y + 1].charAt(x) == '#' ? 1 : 0;

        return new Tile(id, grid);
    }
}
