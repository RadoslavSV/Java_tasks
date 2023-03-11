package Problem1;

import java.util.*;
import java.util.List;

public class DieStream {
    public static HashMap<Integer, Integer> rollingDice() {
        Random rand = new Random();

        List<Integer> dieNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=1; i<=6; i++) {
            hmap.put(i, 0);
        }

        for (int i=0; i<6_000_000; i++) {
            int rolledDie = dieNums.stream().skip(rand.nextInt(0, dieNums.size())).findFirst().get();
            hmap.put(rolledDie, hmap.get(rolledDie)+1);
        }

        return hmap;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> die = rollingDice();

        System.out.println("Face  Frequency");
        for(int i=1; i<=6; i++) {
            System.out.printf("%d     %d\n", i, die.get(i));
        }
    }
}
