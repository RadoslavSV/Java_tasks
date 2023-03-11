package lib;

public enum FoodType {
    BAKERY("Bakery"),
    DAIRY("Dairy"),
    MEAT("Meat"),
    VEGAN("Vegan"),
    VEGETABLE_FRUIT("Vegetable/fruit"),
    BEVERAGES("Beverages"),
    SOUP("Soup");

    private String foodType;

    FoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }
}
