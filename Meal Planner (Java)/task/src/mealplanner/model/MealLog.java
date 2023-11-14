package mealplanner.model;

import java.util.ArrayList;
import java.util.List;

public class MealLog {
    List<Meal> meals;

    public MealLog() {
        meals = new ArrayList<>();
    }

    public List<Meal> getMeals() {
        return this.meals;
    }
}
