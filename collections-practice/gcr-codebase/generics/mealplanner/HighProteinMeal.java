package generics.mealplanner;

public class HighProteinMeal implements MealPlan {

    private int calories;
    private int protein;

    public HighProteinMeal(int calories, int protein) {
        this.calories = calories;
        this.protein = protein;
    }

    @Override
    public String getMealType() {
        return "High-Protein";
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
        return "MealType: High-Protein, Calories: " + calories + ", Protein: " + protein + "g";
    }
}
