package mealplanner.model;

import java.util.List;


public class Meal {
    private String category;
    private String name;
    private List<String> ingredients;

    public Meal() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(String.format("Category: %s\n" +
                "Name: %s\n" +
                "Ingredients:\n", category, name));
        ingredients.stream().forEach(e -> output.append(e + "\n"));
        return output.toString();
    }
}