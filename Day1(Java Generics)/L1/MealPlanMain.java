interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }
}

class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public String getMealDetails() {
        return mealType.getMealType();
    }

    public static <T extends MealPlan> void validateMealPlan(T mealPlan) {
        System.out.println("Validating meal: " + mealPlan.getMealType());
    }
}
public class MealPlanMain {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());

        System.out.println("Meal Plan Details:");
        System.out.println("Vegetarian Meal: " + vegetarianMeal.getMealDetails());
        System.out.println("Vegan Meal: " + veganMeal.getMealDetails());

        System.out.println("\nValidating Meals:");
        Meal.validateMealPlan(vegetarianMeal.mealType);
        Meal.validateMealPlan(veganMeal.mealType);
    }
}