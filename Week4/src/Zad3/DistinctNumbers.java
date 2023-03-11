package Zad3;

import java.util.ArrayList;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> distinct = new ArrayList<>();
        System.out.println("Input a sequence of numbers, ending at 0:");
        int number;
        do {
            number = input.nextInt();
            if(!distinct.contains(number)) {
                distinct.add(number);
            }
        } while(number!=0);

        distinct.remove(distinct.size()-1);

        System.out.println("Distinct numbers: " + distinct);
    }
}
