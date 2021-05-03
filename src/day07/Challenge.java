package day07;

import java.util.*;

public class Challenge {

    private final List<Bag> bags;

    public Challenge(List<Bag> bags) {
        this.bags = bags;
    }

    public int solvePart1() {
        return countParentBags(Collections.singleton("shiny gold"), new HashSet<>());
    }

    public int solvePart2() {
        return countChildBags(Collections.singletonMap("shiny gold", 1), 0);
    }

    private int countParentBags(Set<String> bagsThatSearchForParentBags, Set<String> foundParentBags) {
        if (bagsThatSearchForParentBags.isEmpty()) return foundParentBags.size();

        Set<String> bagsForExtendedSearch = new HashSet<>();
        for (String bagThatSearches : bagsThatSearchForParentBags) {
            for (Bag bag : bags) {

                if (bag.getContent().containsKey(bagThatSearches)) {
                    foundParentBags.add(bag.getColor());
                    bagsForExtendedSearch.add(bag.getColor());
                }
            }
        }
        return countParentBags(bagsForExtendedSearch, foundParentBags);
    }

    private int countChildBags(Map<String, Integer> bagsThatSearchForChildBags, int childBagsCtr) {
        if (bagsThatSearchForChildBags.isEmpty()) return childBagsCtr;

        Map<String, Integer> bagsForExtendedSearch = new HashMap<>();
        for (Map.Entry<String, Integer> bagThatSearches : bagsThatSearchForChildBags.entrySet()) {
            for (Bag bag : bags) {

                if (bag.getColor().equals(bagThatSearches.getKey())) {
                    for (Map.Entry<String, Integer> content : bag.getContent().entrySet()) {
                        String color = content.getKey();
                        int amount = content.getValue() * bagThatSearches.getValue();

                        bagsForExtendedSearch.merge(color, amount, Integer::sum);
                        childBagsCtr += amount;
                    }
                }
            }
        }
        return countChildBags(bagsForExtendedSearch, childBagsCtr);
    }
}
