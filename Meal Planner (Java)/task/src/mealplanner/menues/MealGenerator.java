package mealplanner.menues;

import mealplanner.model.Meal;

import java.util.List;
import java.util.Scanner;

public class MealGenerator {
    private static final String MEALPROMPT = "Which meal do you want to add" +
            " (breakfast, lunch, dinner)?";
    private static final String MEALNAMEPROMPT = "Input the meal's name:";
    private static final String INGREDIENTSPROMPT = "Input the ingredients:";

    private Meal meal;
    private final Scanner scanner;

    public MealGenerator(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        meal = new Meal();
        setMealtype();
        setMealName();
        setIngredients();
        System.out.println(meal);

    }

    public void setMealtype() {
        String input = "";

        while (true) {
            System.out.println(MEALPROMPT);
            input = scanner.nextLine();
            if (input.equals("breakfast") ||
                    input.equals("lunch") ||
                    input.equals("dinner")) {
                break;
            }
        }

        meal.setCategory(input);

    }

    public void setMealName() {
        System.out.println(MEALNAMEPROMPT);
        meal.setName(scanner.nextLine());
    }

    public void setIngredients() {
        System.out.println(INGREDIENTSPROMPT);
        meal.setIngredients(List.of(scanner.nextLine().split(",")));
    }


}