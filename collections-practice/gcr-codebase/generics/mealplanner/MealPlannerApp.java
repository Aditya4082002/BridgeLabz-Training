package generics.mealplanner;

public class MealPlannerApp {
    public static void main(String[] args) {

        Meal<VegetarianMeal> meal1 =
                MealPlanGenerator.generateMealPlan("Aditya",
                        new VegetarianMeal(2000, 90));

        Meal<VeganMeal> meal2 =
                MealPlanGenerator.generateMealPlan("Rahul",
                        new VeganMeal(1800, 80));

        Meal<KetoMeal> meal3 =
                MealPlanGenerator.generateMealPlan("Neha",
                        new KetoMeal(2200, 120, 40));

        Meal<HighProteinMeal> meal4 =
                MealPlanGenerator.generateMealPlan("Sneha",
                        new HighProteinMeal(2500, 160));

        System.out.println("\n--- Final Meal Plans ---");
        System.out.println(meal1);
        System.out.println(meal2);
        System.out.println(meal3);
        System.out.println(meal4);
    }
}
