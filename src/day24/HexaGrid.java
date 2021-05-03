package day24;

import java.util.*;
import java.util.regex.Matcher;

public class HexaGrid {

    private final Set<Position> blackTiles = new HashSet<>();

    public void setTiles(List<String> cardinalTilePaths) {
        locateAndSetTiles(cardinalTilePaths);
    }

    private void locateAndSetTiles(List<String> cardinalTilePaths) {
        cardinalTilePaths.stream()
                .map(this::decodeCardinalsToCartesian)
                .map(Position::determinePosition).forEach(pos -> {
                    if (blackTiles.contains(pos)) blackTiles.remove(pos);
                    else blackTiles.add(pos);
                });
    }

    private List<Vector> decodeCardinalsToCartesian(String cardinalPath) {
        List<Vector> path = new ArrayList<>();
        Matcher matcher;

        while (!cardinalPath.isEmpty())
            for (Direction direction : Direction.values())
                if ((matcher = direction.getPattern().matcher(cardinalPath)).find()) {
                    path.add(direction.getUnitVector());
                    cardinalPath = matcher.replaceFirst("");
                }

        return path;
    }

    public void playTheConway(int rounds) {
        for (int i = 0; i < rounds; i++)
            playRound();
    }

    private void playRound() {
        Set<Position> positionsToFlip = new HashSet<>();
        Map<Position, Integer> whiteNeighborCtrAtPos = new HashMap<>();

        for (Position position : blackTiles) {
            List<Position> neighbors = position.getNeighborPositions();
            int blackNeighborsCtr = 0;

            for (Position pos : neighbors)
                if (blackTiles.contains(pos)) blackNeighborsCtr++;
                else whiteNeighborCtrAtPos.merge(pos, 1, Integer::sum);

            if (blackNeighborsCtr == 0 || blackNeighborsCtr > 2) positionsToFlip.add(position);
        }

        whiteNeighborCtrAtPos.forEach((key, val) -> { if (val == 2) positionsToFlip.add(key); });

        positionsToFlip.forEach(pos -> {
            if (blackTiles.contains(pos)) blackTiles.remove(pos);
            else blackTiles.add(pos);
        });
    }

    public int countFlippedTiles() {
        return blackTiles.size();
    }
}
