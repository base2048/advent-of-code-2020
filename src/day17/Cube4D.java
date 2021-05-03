package day17;

public class Cube4D extends Cube {

    public final Position4D position;

    public Cube4D(Position4D position, boolean isActive) {
        super(isActive);
        this.position = position;
    }
}
