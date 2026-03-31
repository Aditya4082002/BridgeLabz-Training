package generics.mealplanner;

public class KetoMeal implements MealPlan {

    private int calories;
    private int protein;
    private int carbsPerDay;

    public KetoMeal(int calories, int protein, int carbsPerDay) {
        this.calories = calories;
        this.protein = protein;
        this.carbsPerDay = carbsPerDay;
    }

    public int getCarbsPerDay() {
        return carbsPerDay;
    }

    @Override
    public String getMealType() {
        return "Keto";
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
        return "MealType: Keto, Calories: " + calories +
                ", Protein: " + protein + "g, Carbs: " + carbsPerDay + "g";
    }
}
