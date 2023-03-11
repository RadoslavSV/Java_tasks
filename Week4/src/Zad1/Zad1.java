package Zad1;

import java.util.Scanner;
import java.lang.String;

public class Zad1 {
     public static int SHIFT_LENGTH = 3;

    private static char[] alphabet() {
        char[] alp = new char[26];
        char a = 'A';
        for(int i=0; i<26; i++) {
            alp[i] = a++;
        }
        return alp;
    }

    public static String encrypt(String text) {
        char[] alphabet = alphabet();
        char[] textArray = text.toCharArray();

        for(int i=0; i<textArray.length; i++) {
            textArray[i] = alphabet[(textArray[i] - 'A' + SHIFT_LENGTH) % 26];
        }
        return new String(textArray);
    }

    public static String decrypt(String text) {
        char[] alphabet = alphabet();
        char[] textArray = text.toCharArray();

        for(int i=0; i<textArray.length; i++) {
            textArray[i] = alphabet[(textArray[i] - 'A' - SHIFT_LENGTH + 26) % 26];
        }
        return new String(textArray);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input SHIFT_LENGTH: ");
        SHIFT_LENGTH = Integer.parseInt(input.nextLine());
        int choice;
        do {
            System.out.print("Input 1 for encrypting or 2 for decrypting: ");
            choice = Integer.parseInt(input.nextLine());
        } while (choice<1 || choice>2);

        if(choice==1) {
            System.out.print("Input text to encrypt: ");
            String text = input.nextLine().toUpperCase();
            String encrypted = encrypt(text);
            System.out.printf("The encrypted text is %s\n", encrypted);
        } else {
            System.out.print("Input text to decrypt: ");
            String text = input.nextLine().toUpperCase();
            String decrypted = decrypt(text);
            System.out.printf("The decrypted text is %s\n", decrypted);
        }
    }
}
