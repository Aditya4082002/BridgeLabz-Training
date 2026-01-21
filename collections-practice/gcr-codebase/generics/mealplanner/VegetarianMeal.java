package generics.mealplanner;

public class VegetarianMeal implements MealPlan {

    private int calories;
    private int protein;

    public VegetarianMeal(int calories, int protein) {
        this.calories = calories;
        this.protein = protein;
    }

    @Override
    public String getMealType() {
        return "Vegetarian";
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
        return "MealType: Vegetarian, Calories: " + calories + ", Protein: " + protein + "g";
    }
}
