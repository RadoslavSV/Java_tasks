package Problem1;

import java.util.*;

public class ChocolateEggsSimulation {
    private static double moneyNeededForTenEggs() {
        // 10 distinct chocolate eggs will be represented by the numbers from 1 to 10
        // will store them in a set (no duplicate elements are allowed)
        Set<Integer> set = new TreeSet<>(); // initially the set will be empty
        int cntNeededEggs = 0;
        // iterate until the set has been filled up
        // 10 is the needed size for our task, since we cannot add more unique elements
        while(set.size()<10) {
            // generating a random number in range [1,10], which is the current randomly drawn egg
            int egg = new Random().ints(1, 11).findFirst().getAsInt();
            // add it into the set
            set.add(egg);
            cntNeededEggs++;
        }
//         System.out.println("All eggs have been collected!");
//         System.out.println(set);
        return cntNeededEggs*0.5;
    }

    public static void main(String[] args) {
        // we will create a simulation by generating 10000 random experiments
        // each of them will return a value, which is the needed number to collect all 10 eggs
        // calculate their mean (average)
        double sum = 0;
        final int NUM_EXPERIMENTS = 10000;
        for(int i=0; i<NUM_EXPERIMENTS; i++) {
            sum += moneyNeededForTenEggs();
        }
        System.out.printf("%d experiments have been executed.\n", NUM_EXPERIMENTS);
        System.out.printf("Average amount of money for collecting all 10 unique eggs is %.2f leva.\n", sum/NUM_EXPERIMENTS);
    }
}
