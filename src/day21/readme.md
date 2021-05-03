## [AoC 2020 Day 21: Allergen Assessment](https://adventofcode.com/2020/day/21)

Pretty much like the challenge from day 16. First, for each allergen, we collect all foods (ingredient lists) in which this allergen occurs. Then we eliminate all ingredients per allergen that do not appear in each of all associated ingredient lists. And finally, we recursively pick out the allergens and their corresponding ingredients.

As you can see once again by the method *collectIngredientCandidatesPerAllergen()* I mostly prefer to use the Stream-API. For the protocol and for all those who prefer the old school approach, here a classic for-loop way:

```Java
Map<String, List<List<String>>> allergens = new HashMap<>();

for (Food food : foods) {
    for (String allergen : food.getAllergens()) {

        allergens.putIfAbsent(allergen, new ArrayList<>());
        allergens.get(allergen).add(food.getIngredients());

    }
}
return allergens;
```

In the example above, collecting the data into the Map would also be implementable as oneliner:

```Java
allergens.merge(allergen, new ArrayList<>(Collections.singleton(food.getIngredients())), (v1, v2) -> { v1.addAll(v2); return v1; });
```

*intersectIngredientCandidates()* relies on the use of an intersecting collector. Of course, it is possible to use this collector already in *collectIngredientCandidatesPerAllergen()* as Downstream, but for the benefit of clarity it is used in a separate method. Without an intersecting collector we could implement the method as follows:

```Java
private Map<String, List<String>> intersectIngredientCandidates(Map<String, List<List<String>>> ingredientCandidates) {
    return ingredientCandidates.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                List<String> intersected = new ArrayList<>(entry.getValue().get(0));
                entry.getValue().subList(1, entry.getValue().size()).forEach(intersected::retainAll);
                return intersected;
            }));
}
```

Note that all the time we have the allergens as keys in the Maps. However, the final method *determineAllergens()* returns a Map with the ingredients as keys and their allergens as values. Now back to the important things in life. Classic ingredient list for a cookie:

    - 300 g Flour
    - 110 g Brown Sugar
    - 120 g Cane Sugar
    - 250 g Butter
    - 2 Eggs
    - 1 tsp. Baking Soda
    - 1/2 tsp. Salt
    - 1 pck. Vanilla Sugar
    - 3 Chocolate Bars

---

![AoC 2020 Day 21](day21--Allergen_Assessment.png?raw=true)
