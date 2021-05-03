package day11;

public class Seat extends Tile {

    private boolean isOccupied;

    public Seat(Position position) {
        super(position);
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public void toggleOccupation() {
        isOccupied = !isOccupied;
    }
}
