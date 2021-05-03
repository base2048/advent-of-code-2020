package day21;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Challenge {

    private final List<Food> foods;
    private final Map<String, String> allergensByIngredients;

    public Challenge(List<Food> foods) {
        this.foods = foods;
        this.allergensByIngredients = validateAllergens();
    }

    public int solvePart1() {
        return (int) foods.stream()
                .flatMap(food -> food.getIngredients().stream())
                .filter(Predicate.not(allergensByIngredients::containsKey))
                .count();
    }

    public String solvePart2() {
        return allergensByIngredients.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(","));
    }

    private Map<String, String> validateAllergens() {
        Map<String, List<List<String>>> ingredientCandidatesPerAllergen = collectIngredientCandidatesPerAllergen();
        Map<String, List<String>> conceivableIngredientsPerAllergen = intersectIngredientCandidates(ingredientCandidatesPerAllergen);

        return determineAllergens(conceivableIngredientsPerAllergen, new HashMap<>());
    }

    private Map<String, List<List<String>>> collectIngredientCandidatesPerAllergen() {
        return foods.stream()
                .flatMap(food -> food.getAllergens().stream()
                        .map(allergen -> new Object() {
                            final String allg = allergen;
                            final List<String> ingr = food.getIngredients();
                        }))
                .collect(Collectors.groupingBy(token -> token.allg, Collectors.mapping(token -> token.ingr, Collectors.toList())));
    }

    private Map<String, List<String>> intersectIngredientCandidates(Map<String, List<List<String>>> ingredientCandidates) {
        return ingredientCandidates.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().collect(intersecting())));
    }

    private Map<String, String> determineAllergens(Map<String, List<String>> conceivablesPerAllergen, Map<String, String> verifiedAllergens) {
        if (conceivablesPerAllergen.isEmpty()) return verifiedAllergens;

        conceivablesPerAllergen.entrySet().removeIf(entry -> {
            if (entry.getValue().size() > 1) return false;

            String ingredient = entry.getValue().get(0);
            verifiedAllergens.put(ingredient, entry.getKey());
            conceivablesPerAllergen.forEach((key, value) -> value.remove(ingredient));

            return true;
        });

        return determineAllergens(conceivablesPerAllergen, verifiedAllergens);
    }

    private Collector<List<String>, ?, List<String>> intersecting() {
        class Intersection {
            List<String> result;

            void intersect(List<String> list) {
                if (result == null) result = new ArrayList<>(list);
                else result.retainAll(list);
            }

            Intersection combine(Intersection other) {
                if (result == null) return other;
                if (other.result != null) result.retainAll(other.result);
                return this;
            }

            List<String> finish() {
                return result == null ? Collections.emptyList() : result;
            }
        }

        return Collector.of(Intersection::new, Intersection::intersect, Intersection::combine, Intersection::finish, Collector.Characteristics.UNORDERED);
    }
}
