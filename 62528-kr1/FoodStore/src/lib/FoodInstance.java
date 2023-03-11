package lib;

import java.util.*;

public class FoodInstance implements Comparable<FoodInstance>{
    private int foodKey; // служи за индекс на елемент от масива FOOD_PRODUCTS
    private String foodName; // име на обект от FoodInstance
    private double foodPrice; // цена на обект от FoodInstance

    public int getFoodKey() {
        return foodKey;
    }

    public void setFoodKey(int foodKey) {
        this.foodKey = foodKey;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public FoodInstance(int foodKey, String foodName, double foodPrice) {
        this.foodKey = foodKey;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        INSTANCE_ID = String.format("%s%04d", getFoodName(), getFoodKey());
    }

    @Override
    public int compareTo(FoodInstance o) {
//        return (int) (this.getFoodPrice() - o.getFoodPrice());
        return Double.compare(this.getFoodPrice(), o.getFoodPrice());
    }

    public final String INSTANCE_ID;

    @Override
    public String toString() {
        return String.format("%s,Price: %.2f", this.INSTANCE_ID, getFoodPrice());
    }

//    public static void main(String[] args) {
//        FoodInstance fi1 = new FoodInstance(85, "Lemon juice", 2);
//        FoodInstance fi2 = new FoodInstance(137, "Beans", 71.11);
//        FoodInstance fi3 = new FoodInstance(1003, "Watermelon", 71.03);
//        FoodInstance fi4 = new FoodInstance(1003, "Watermelon", 1.11);
////        System.out.println(fi1);
////        System.out.println(fi2);
////        System.out.println(fi3);
//        FoodInstance[] ls = new FoodInstance[4];
//        ls[0]=fi1;
//        ls[1]=fi2;
//        ls[2]=fi3;
//        ls[3]=fi4;
//        for(var x : ls) System.out.println(x);
//        Arrays.sort(ls);
//        System.out.println();
//        for(var x : ls) System.out.println(x);
//    }
}
