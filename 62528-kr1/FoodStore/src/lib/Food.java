package lib;

public class Food {
    private String name;
    private FoodCategory foodCategory;
    private FoodType foodType;
    private boolean isSpicy;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodCategory getFoodCategory() {
        return this.foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public FoodType getFoodType() {
        return this.foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public boolean isSpicy() {
        return this.isSpicy;
    }

    public void setSpicy(boolean spicy) {
        this.isSpicy = spicy;
    }

    public Food(String name, FoodCategory foodCategory, FoodType foodType, boolean isSpicy) {
        this.name = name;
        this.foodCategory = foodCategory;
        this.foodType = foodType;
        this.isSpicy = isSpicy;
    }

    public Food(Food f) {
        setName(f.getName());
        setFoodCategory(f.getFoodCategory());
        setFoodType(f.getFoodType());
        setSpicy(f.isSpicy());
    }

    @Override
    public String toString() {
        String isSpicy = (isSpicy()) ? "Yes" : "No";
        return String.format("Food{ %s category: %s, type: %s, spicy: %s}",
                name, foodCategory.getCategoryName(), foodType.getFoodType(), isSpicy);
    }

    public static final Food[] FOOD_PRODUCTS = new Food[7];
    static {
        FOOD_PRODUCTS[0] = new Food("Biscuits" , FoodCategory.BREAKFAST, FoodType.BAKERY, false);
        FOOD_PRODUCTS[1] = new Food("Paste" , FoodCategory.DESERTS, FoodType.VEGAN, false);
        FOOD_PRODUCTS[2] = new Food("Cheese" , FoodCategory.BREAKFAST, FoodType.DAIRY, false);
        FOOD_PRODUCTS[3] = new Food("Fried meat" , FoodCategory.LUNCH, FoodType.MEAT, true);
        FOOD_PRODUCTS[4] = new Food("Beans" , FoodCategory.DINNER, FoodType.SOUP, true);
        FOOD_PRODUCTS[5] = new Food("Watermelon" , FoodCategory.LUNCH, FoodType.VEGETABLE_FRUIT, true);
        FOOD_PRODUCTS[6] = new Food("Lemon juice", FoodCategory.DINNER, FoodType.BEVERAGES, false);
    }

//    public static void main(String[] args) {
//        Food f1 = new Food("Beans", FoodCategory.DINNER, FoodType.SOUP, true);
//        Food f2 = new Food("Paste" , FoodCategory.DESERTS, FoodType.VEGAN, false);
//        Food fN = new Food("Watermelon" , FoodCategory.LUNCH, FoodType.VEGETABLE_FRUIT, true);
//        Food f3 = new Food(fN);
//        System.out.println(f1);
//        System.out.println(f2);
//        System.out.println(f3);
//
////        for(var x : FOOD_PRODUCTS) {
////            System.out.println(x);
////        }
//    }
}
