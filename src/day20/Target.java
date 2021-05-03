package day20;

public class Target {

    private final Tile tile;
    private final Location edge;

    public Target(Tile tile, Location edge) {
        this.tile = tile;
        this.edge = edge;
    }

    public Tile getTile() {
        return tile;
    }

    public Location getEdge() {
        return edge;
    }
}
