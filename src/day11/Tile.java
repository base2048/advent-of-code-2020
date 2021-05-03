package day11;


public abstract class Tile {

    private final Position position;

    public Tile(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
