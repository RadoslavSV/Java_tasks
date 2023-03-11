package Zad2;

import java.util.Scanner;

public class LuhnAlgorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter credit card number: ");
        String cc = input.next();
        char[] creditCard = cc.toCharArray();

        if(creditCard.length<13 || creditCard.length>16) {
            System.out.println("Invalid credit card number!");
            System.exit(0);
        }
        if( !(creditCard[0]=='4' || creditCard[0]=='5' || creditCard[0]=='6' || (creditCard[0]=='3' && creditCard[1]=='7')) ) {
            System.out.println("Invalid credit card number!");
            System.exit(0);
        }

        int sum = 0;
        int newDigit;
        for(int i=creditCard.length-2; i>=0; i-=2) {
            newDigit = Character.getNumericValue(creditCard[i])*2;
            if(newDigit>9) {
                newDigit = newDigit/10 + newDigit%10;
            }
            sum += newDigit;
        }
        for(int i=creditCard.length-1; i>=0; i-=2) {
            sum += Character.getNumericValue(creditCard[i]);
        }

        if(sum%10!=0) {
            System.out.println("Invalid credit card number!");
        } else {
            System.out.println("Valid credit card number!");
        }
    }
}
