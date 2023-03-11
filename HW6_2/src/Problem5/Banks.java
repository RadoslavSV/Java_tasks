package Problem5;

import java.util.*;
import java.util.stream.Collectors;

public class Banks {
    public static void main(String[] args) {
        int n, limits;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        n = scanner.nextInt();
        limits = scanner.nextInt();

        HashMap<Integer, Double> hmap = new HashMap<>();
        double[][] borrowers = new double[n][n];

        for(int i=0; i<n; i++) {
            double balance;
            int m;
            balance = scanner.nextDouble();
            m = scanner.nextInt();

            hmap.put(i, balance);

            for(int j=0; j<m; j++) {
                int bank;
                double loan;
                bank = scanner.nextInt();
                loan = scanner.nextDouble();

                borrowers[bank][i] = loan;
                hmap.put(i, hmap.get(i)+loan);
            }
        }

//        for(int i=0; i<n; i++) {
//            System.out.println("Bank " + i + " has " + hmap.get(i) + " total assets.");
//        }
//
//        for(int i=0; i<n; i++) {
//            for (int j=0; j<borrowers[i].length; j++) {
//                if(borrowers[i][j]!=0) System.out.println("Bank " + i + " loans to bank " + j);
//            }
//        }

        List<Integer> unsafeList = new ArrayList<>();

        int cnt = 0;
        while(cnt<5) {
            for (int i = 0; i < n; i++) {
                if (hmap.get(i) < limits) {
                    unsafeList.add(i);

                    for (int j = 0; j < borrowers[i].length; j++) {
                        if (borrowers[i][j] != 0) {
                            hmap.put(j, hmap.get(j) - borrowers[i][j]);
                            borrowers[i][j] = 0;
                        }
                    }
                }
            }
            cnt++;
        }

        unsafeList = unsafeList.stream().distinct().collect(Collectors.toList());

        if(unsafeList.isEmpty()) System.out.print("\nNo unsafe banks!");
        else {
            System.out.print("\nUnsafe banks are ");
            for (var x : unsafeList) {
                System.out.print(x + " ");
            }
        }
    }
}
/*
5 201
25 2 1 100.5 4 320.5
125 2 2 40 3 85
175 2 0 125 3 75
75 1 0 125
181 1 2 125

Unsafe banks are 3 1
--------------------------
5 160
25 2 1 100.5 4 320.5
125 2 2 40 3 85
175 2 0 125 3 75
75 1 0 10
181 1 2 125

Unsafe banks are 3
--------------------------
5 200
25 2 1 100.5 4 320.5
125 2 4 40 3 85
100 2 1 195 3 75
75 1 0 10
181 1 0 125

Unsafe banks are 3 1 2
 */
