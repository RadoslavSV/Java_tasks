import java.util.*;

public class Tokenizer {
    public static int sumNumbersInToken(String token, int start, int end) {
        int sm = 0;
        for(int i=start; i<=end; i++) {
            sm += token.charAt(i) - '0';
        }
        return sm;
    }

    public static String cardToToken(String card) {
        String token = "";
        Random rand = new Random();

        for(int i=0; i<12; i++) {
            char c;
            do { // generate random number from 0 to 9 (done at least once)
                c = (char) (rand.nextInt('0', '9' + 1));
                while(i==0 && (c=='3' || c=='4' || c=='5' || c=='6')) {   // only during first iteration
                    c = (char) (rand.nextInt('0', '9' + 1)); // change the number till it's different from 3,4,5,6
                }
            } while(c==card.charAt(i)); // repeat that until that number is different from its corresponding in the card

            token += c;
        }

        int sum = sumNumbersInToken(token, 0, 11); // use function to sum all numbers from 0 to 11 inclusive

        while(sum%10 == 0) { // while that sum is divisible by 10, change the last number till it is not
            char c = (char) (rand.nextInt('0', '9' + 1));
            token = token.substring(0, 11) + c;
            sum = sumNumbersInToken(token, 0, 11);
        }

        for(int i=12; i<16; i++) {
            token += card.charAt(i);
        }

        return token;
    }

    public static boolean LuhnAlgorithm(String card)
    {
        int sum = 0;
        for(int i=card.length()-2; i>=0; i-=2)
        {
            int num = card.charAt(i) - '0';
            num *= 2;

            int sm = 0;
            int numCp = num;
            if(numCp>=10) {
                while(numCp!=0) {
                    sm += numCp%10;
                    numCp /= 10;
                }
            }

            sum += (num>=10) ? sm : num ;
        }

        for(int i=card.length()-1; i>=0; i-=2) {
            sum += card.charAt(i) - '0';
        }

        return (sum%10 == 0);
    }

    public static boolean isCardValid(String card) {
        return (card.charAt(0)=='3' || card.charAt(0)=='4' || card.charAt(0)=='5' || card.charAt(0)=='6')
                && LuhnAlgorithm(card);
    }
}
