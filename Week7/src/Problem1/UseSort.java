package Problem1;

import java.util.Arrays;
import java.util.Random;

public class UseSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[random.nextInt(15, 31)]; //random number between 15 and 30

        for(int i=0; i<numbers.length; i++) {
            numbers[i] = random.nextInt(-100, 100);
        }

        SortOrder sortOrder = new SortOrder();
        Sortable upward = sortOrder.getUpward();
        Sortable downward = sortOrder.getDownward();

        MySort mySortUpward = new MySort();
        MySort mySortDownward = new MySort(downward);

        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(numbers));

        System.out.println("\nSorted ascending:");
        mySortUpward.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println("\nSorted descending:");
        mySortDownward.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println("\nSorted ascending:");
        mySortDownward.setCallback(upward);
        mySortDownward.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
