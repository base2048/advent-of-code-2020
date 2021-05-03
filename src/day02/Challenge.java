package day02;

import java.util.List;

public class Challenge {

    private final List<String> ruleSets;

    public Challenge(List<String> ruleSets) {
        this.ruleSets = ruleSets;
    }

    public int solvePart1() {
        var validator = PasswordValidatorFactory.create(1);
        return (int) ruleSets.stream().filter(validator::validate).count();
    }

    public int solvePart2() {
        var validator = PasswordValidatorFactory.create(2);
        return (int) ruleSets.stream().filter(validator::validate).count();
    }
}
