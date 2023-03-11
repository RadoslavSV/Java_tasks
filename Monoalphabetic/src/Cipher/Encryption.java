package Cipher;

import java.util.Arrays;

public class Encryption {
    public IEncryptable getMonoCipherMethod() {
        return new MonoEncryption();
    }

    private class MonoEncryption implements IEncryptable {

        private int[] getCounts(String cipher){
            char[] cipherChars = cipher.toCharArray();
            int[] counts = new int[26];
            for(int i=0; i<cipherChars.length; i++) {
                counts[cipherChars[i] - 'A']++;
            }
            return counts;
        }
        private int[] makeCipher(String cipher){
            int[] cipherPad = new int[26];
            int[] counts = getCounts(cipher);
            char[] cipherText = cipher.toCharArray();
            int index = 0;

            for(int i=0; i<cipherText.length; i++) {
                if(counts[cipherText[i]-'A'] > 0) {
                    cipherPad[index] = cipherText[i]-'A';
                    counts[cipherText[i]-'A'] *= -1;
                    index++;
                }
            }

            for(int i=25; i>=0; i--) {
                if(counts[i] == 0) {
                    cipherPad[index] = i;
                    index++;
                }
            }

            return cipherPad;
        }

        @Override
        public String encrypt(String plainText, String cipher) {
            plainText = plainText.toUpperCase();
            cipher = cipher.toUpperCase();

            int[] cipherPad = makeCipher(cipher);
            char[] plain = plainText.toCharArray();
            char[] encrypted = new char[plain.length];

            for(int i=0; i<plain.length; i++) {
                encrypted[i] = (char) (cipherPad[plain[i]-'A'] + 'A');
            }
            return String.valueOf(encrypted);
        }

        @Override
        public String decrypt(String cipherText, String cipher) {
            cipherText = cipherText.toUpperCase();
            cipher = cipher.toUpperCase();

            int[] cipherPad = makeCipher(cipher);
            char[] cipherArr = cipherText.toCharArray();
            char[] decrypted = new char[cipherArr.length];

            for(int i=0; i<cipherArr.length; i++) {
                int idx = 0;
                for(int j=0; j<cipherPad.length; j++) {
                    if((char)(cipherPad[j]+'A')==cipherArr[i]) {
                        idx = j;
                        break;
                    }
                }
                decrypted[i] = (char)(idx+(int)'A');
            }

            return String.valueOf(decrypted);
        }
    }
}
