package day17;

public class Vector4D extends Vector {

    public final Direction4D direction;

    public Vector4D(Direction4D direction, int length) {
        super(length);
        this.direction = direction;
    }
}
