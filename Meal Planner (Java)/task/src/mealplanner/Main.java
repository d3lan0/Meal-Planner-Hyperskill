package mealplanner;


import mealplanner.menues.MealGenerator;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MealGenerator mealGenerator = new MealGenerator(scanner);
        mealGenerator.start();
    }
}