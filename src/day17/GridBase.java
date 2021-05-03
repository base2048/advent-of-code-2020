package day17;

import java.util.*;

public abstract class GridBase implements Grid {

    protected final int cycles;
    protected final int width, height, length;
    protected final int xCenterOffset, yCenterOffset, zCenterOffset;

    public GridBase(int width, int height, int length, int cycles) {
        this.cycles = cycles;

        this.width = width;
        this.height = height;
        this.length = length;

        this.xCenterOffset = width / 2;
        this.yCenterOffset = height / 2;
        this.zCenterOffset = length / 2;
    }

    public int getCycles() {
        return cycles;
    }

    public void runBootProcess() {
        List<Cube> cubesToToggleActivation = new ArrayList<>();

        for (int i = 0; i < cycles; i++) {
            this.streamAllCubes().forEach(cube -> {
                int numberOfActiveNeighbors = (int) this.streamNeighbors(cube).filter(Cube::isActive).count();
                if (shallToggleActivation(cube, numberOfActiveNeighbors))
                    cubesToToggleActivation.add(cube);
            });

            cubesToToggleActivation.forEach(Cube::toggleActivation);
            cubesToToggleActivation.clear();
        }
    }

    private boolean shallToggleActivation(Cube cube, int numberOfActiveNeighbors) {
        if (cube.isActive && (numberOfActiveNeighbors < 2 || numberOfActiveNeighbors > 3)) return true;
        if (!cube.isActive && numberOfActiveNeighbors == 3) return true;
        return false;
    }

    public int countActiveCubes() {
        return (int) this.streamAllCubes().filter(Cube::isActive).count();
    }
}
