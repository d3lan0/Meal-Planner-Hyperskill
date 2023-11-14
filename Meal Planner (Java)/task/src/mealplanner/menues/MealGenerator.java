package mealplanner.menues;

import mealplanner.model.Meal;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public Meal start() {
        meal = new Meal();
        setMealtype();
        setMealName();
        setIngredients();
        return meal;

    }

    public void setMealtype() {
        String input = "";
        System.out.println(MEALPROMPT);
        while (true) {
            input = scanner.nextLine();
            if (input.equals("breakfast") ||
                    input.equals("lunch") ||
                    input.equals("dinner")) {
                meal.setCategory(input);
                break;
            } else {
                System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            }
        }
    }

    public void setMealName() {
        String input = "";
        System.out.println(MEALNAMEPROMPT);

        while (true) {
            input = scanner.nextLine();
            if (!input.isBlank() && isValidInput(input)) {
                meal.setName(input);
                break;
            }
            System.out.println("Wrong format. Use letters only!");
        }
    }

    private boolean isValidInput(String input) {
        String sub = input.substring(input.length() - 2);

        if (", ".equals(sub)) {
            return false;
        }

        Pattern pattern = Pattern.compile("^[^\\d\\W][\\W\\D\\s]*[^ \\d\\W]$");
        List<String> ingredients = List.of(input.split(", "));
        Boolean validEntries = ingredients.stream().allMatch(e -> {
            Matcher matcher = pattern.matcher(e);
            return matcher.find();
        });

        return validEntries;

    }

    public void setIngredients() {
        String input = "";
        System.out.println(INGREDIENTSPROMPT);

        while (true) {
            input = scanner.nextLine();

            if (!input.isBlank() && isValidInput(input)) {
                meal.setIngredients(List.of(input.split(",")));
                break;
            } else {
                System.out.println("Wrong format. Use letters only!");
            }
        }

    }


}