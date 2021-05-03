package day17;

public abstract class Cube {

    public boolean isActive;

    public Cube(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void toggleActivation() {
        isActive = !isActive;
    }
}
