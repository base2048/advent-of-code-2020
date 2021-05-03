package day06;

import java.util.List;

public class Challenge {

    private final List<Group> groups;

    public Challenge(List<Group> groups) {
        this.groups = groups;
    }

    public int solvePart1() {
        return groups.stream().mapToInt(Group::getDeclarationsAnyoneCtr).sum();
    }

    public int solvePart2() {
        return groups.stream().mapToInt(Group::getDeclarationsEveryoneCtr).sum();
    }
}
