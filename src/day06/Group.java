package day06;

import java.util.*;
import java.util.stream.Collectors;

public class Group {

    private final List<String> declarations;

    public Group(List<String> declarations) {
        this.declarations = declarations;
    }

    public int getDeclarationsAnyoneCtr() {
        return countDeclarationsAnyone();
    }

    public int getDeclarationsEveryoneCtr() {
        /*
         * countDeclarationsEveryoneByMap(): faster
         * countDeclarationsEveryoneByStream(): cooler
         */
        final boolean SHOULD_COUNT_BY_MAP = false;

        return SHOULD_COUNT_BY_MAP
                ? countDeclarationsEveryoneByMap()
                : countDeclarationsEveryoneByStream();
    }

    public int countDeclarationsAnyone() {
        return (int) String.join("", declarations)
                .chars()
                .distinct()
                .count();
    }

    private int countDeclarationsEveryoneByMap() {
        Map<Integer, Integer> countsByAnswer = new HashMap<>();
        for (String declaration : declarations)
            declaration.chars().forEach(answer -> countsByAnswer.merge(answer, 1, Integer::sum));

        int ctr = 0;
        for (int val : countsByAnswer.values())
            ctr += val == declarations.size() ? 1 : 0;

        return ctr;
    }

    private int countDeclarationsEveryoneByStream() {
        return declarations.stream()
                .map(d -> d.chars().mapToObj(c -> (char) c).collect(Collectors.toList()))
                .reduce((accList, currList) -> currList.stream()
                        .filter(accList::contains)
                        .collect(Collectors.toList()))
                .orElseThrow()
                .size();
    }
}
