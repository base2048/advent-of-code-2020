package day17;

public class Cube3D extends Cube {

    public final Position3D position;

    public Cube3D(Position3D position, boolean isActive) {
        super(isActive);
        this.position = position;
    }
}
