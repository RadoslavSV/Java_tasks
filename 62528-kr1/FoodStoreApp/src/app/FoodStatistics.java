package app;

import lib.FoodCategory;
import lib.FoodInstance;

import java.util.*;
import static lib.Food.FOOD_PRODUCTS;

public class FoodStatistics {
    private List<FoodInstance> data;

    public FoodStatistics(List<FoodInstance> data) {
        this.data = data;
    }

    public void generateData() {
        Random rand = new Random();
        for(int i=0; i<60; i++) {
            int idx = rand.nextInt(0, 7);
            String fName = FOOD_PRODUCTS[idx].getName();
            double fPrice = rand.nextDouble(1.00,25.01);

            FoodInstance fi1 = new FoodInstance(idx, fName, fPrice);
            data.add(fi1);
        }

//        for(var x : data) {
//            System.out.println(x);
//        }
        data.stream().sorted(Comparator.comparing(FoodInstance::getFoodName)).sorted(Comparator.comparing(FoodInstance::getFoodPrice))
                .sorted(Collections.reverseOrder()).forEach(System.out::println);
    }

    void printFoodCategories() {
        List<FoodCategory> ls = new ArrayList<>();
        ls.add(FoodCategory.LUNCH);
        ls.add(FoodCategory.DESERTS);
        ls.add(FoodCategory.DINNER);
        ls.add(FoodCategory.BREAKFAST);

        ls.stream().sorted(Comparator.comparing(FoodCategory::getCategoryName)).forEach(System.out::println);
    }

    void groupByFoodCount(){
        for(int i=0; i<7; i++) {
            String nm = FOOD_PRODUCTS[i].getName();
            long cnt = data.stream().filter(x -> x.getFoodName().equals(nm)).count();
            System.out.printf("%-15s has %d instances in data.\n", nm, cnt);
        }
    }

    public static void main(String[] args) {
        List<FoodInstance> myData = new ArrayList<>();
        FoodStatistics fs1 = new FoodStatistics(myData);

        System.out.println("FOOD_PRODUCTS array consists of:");
        for(var x : FOOD_PRODUCTS) {
            System.out.println(x);
        }
        System.out.println();

        System.out.println("Method generateData():");
        fs1.generateData();
        System.out.println();

        System.out.println("Enum type 'FoodCategory' has possible values:");
        fs1.printFoodCategories();

        System.out.println("\nFood grouped by their name:");
        fs1.groupByFoodCount();
    }
}
