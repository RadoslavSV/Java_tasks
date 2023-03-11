package Zad1;

import java.util.Vector;

public class Zad1 {
    public static void main(String[] args) {
        Vector<String> vec = new Vector<String>();

        //Generate all possible numbers (combinations of five ranged digits) and store them in a vector
        for(int i=3; i<=9; i++) {
            String str1 = String.format("%c", (char)(i+'0'));
            for(int j=2; j<=8; j++) {
                String str2 = String.format("%s%c", str1, (char)(j+'0'));
                for(int k=4; k<=9; k++) {
                    String str3 = String.format("%s%c", str2, (char)(k+'0'));
                    for(int l=1; l<=6; l++) {
                        String str4 = String.format("%s%c", str3, (char)(l+'0'));
                        for(int t=6; t<=9; t++) {
                            String str5 = String.format("%s%c", str4, (char)(t+'0'));

                            vec.add(str5); //System.out.printf("%s\n", str5);
                        }
                    }
                }
            }
        }

        int allNumbers = vec.size();
        int divisibleBy12 = 0;

        for(int i=0; i<allNumbers; i++) {
            int first = (int)(vec.get(i).charAt(0)-'0');
            int second = (int)(vec.get(i).charAt(1)-'0');
            int third = (int)(vec.get(i).charAt(2)-'0');
            int fourth = (int)(vec.get(i).charAt(3)-'0');
            int fifth = (int)(vec.get(i).charAt(4)-'0');
            int num = first*10000 + second*1000 + third*100 + fourth*10 + fifth;
            if(num%12==0) {
                divisibleBy12++;
            }
        }
        double res = (double)(divisibleBy12)/(double)(allNumbers)*100;

        System.out.printf("Count of all 5-digit numbers that can be made is %d.\n", allNumbers);
        System.out.printf("Count of those of them that are divisible by 12 is %d.\n", divisibleBy12);
        System.out.printf("Probability that one randomly selected number of those %d is divisible by 12 is %.2f%%.\n",
                          allNumbers, res);

    }
}
