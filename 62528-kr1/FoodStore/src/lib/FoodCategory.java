package lib;

public enum FoodCategory {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DESERTS("Desserts"),
    DINNER("Dinner");

    private final String categoryName;

    FoodCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        String nm = "";
        if(categoryName.equals("Breakfast")) nm = "BREAKFAST";
        if(categoryName.equals("Lunch")) nm = "LUNCH";
        if(categoryName.equals("Desserts")) nm = "DESERTS";
        if(categoryName.equals("Dinner")) nm = "DINNER";

        return String.format("%s:%s", nm, getCategoryName());
    }

    public static void main(String[] args) {
        FoodCategory fc1 = FoodCategory.LUNCH;
        FoodCategory fc2 = FoodCategory.BREAKFAST;
        System.out.println(fc1);
        System.out.println(fc2);
    }
}
