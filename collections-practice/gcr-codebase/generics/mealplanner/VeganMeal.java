package generics.mealplanner;

public class VeganMeal implements MealPlan {

    private int calories;
    private int protein;

    public VeganMeal(int calories, int protein) {
        this.calories = calories;
        this.protein = protein;
    }

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public int getCaloriesPerDay() {
        return calories;
    }

    @Override
    public int getProteinPerDay() {
        return protein;
    }

    @Override
    public String toString() {
        return "MealType: Vegan, Calories: " + calories + ", Protein: " + protein + "g";
    }
}
