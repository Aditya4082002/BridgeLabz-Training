package generics.mealplanner;
public class MealPlanGenerator {

    //Generic method: validates any type of MealPlan
    public static <T extends MealPlan> Meal<T> generateMealPlan(String userName, T plan) {

        // Basic validation
        if (plan.getCaloriesPerDay() < 1000 || plan.getCaloriesPerDay() > 4000) {
            throw new IllegalArgumentException("Calories must be between 1000 and 4000");
        }

        if (plan.getProteinPerDay() < 30 || plan.getProteinPerDay() > 300) {
            throw new IllegalArgumentException("Protein must be between 30g and 300g");
        }

        System.out.println("Meal Plan Generated Successfully for: " + userName);
        return new Meal<>(userName, plan);
    }
}

