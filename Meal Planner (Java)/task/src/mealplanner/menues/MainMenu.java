package mealplanner.menues;

import mealplanner.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private MealGenerator mealGenerator;
    private Scanner scanner;
    private List<Meal> meals;

    public MainMenu() {
        scanner = new Scanner(System.in);
        mealGenerator = new MealGenerator(scanner);
        meals = new ArrayList<>();
    }

    public void run() {
        while (true) {
            String action = getAction();
            processInput(action);
        }
    }

    private String getAction() {
        String input = "";
        while (true) {
            System.out.println("What would you like to do (add, show, exit)?");
            input = scanner.nextLine();
            if (input.equals("add") ||
                    input.equals("show") ||
                    input.equals("exit")) {
                break;
            }
        }
        return input;
    }

    private void processInput(String input) {

        if (input.equals("add")) {
            meals.add(mealGenerator.start());
            System.out.println("The meal has been added!");
        }
        if (input.equals("show")) {
            printMeals();
        }
        if (input.equals("exit")) {
            System.out.println("Bye!");
            System.exit(0);
        }
    }

    private void printMeals() {
        if (meals.isEmpty()) {
            System.out.println("No meals saved. Add a meal first.");
        } else {
            meals.stream().forEach(System.out::println);
        }
    }

}
