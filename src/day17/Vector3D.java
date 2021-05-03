package day17;

public class Vector3D extends Vector {

    public final Direction3D direction;

    public Vector3D(Direction3D direction, int length) {
        super(length);
        this.direction = direction;
    }
}
