package day21;

import java.util.List;

public class Food {

    private final List<String> ingredients;
    private final List<String> allergens;

    public Food(List<String> ingredients, List<String> allergens) {
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getAllergens() {
        return allergens;
    }
}
