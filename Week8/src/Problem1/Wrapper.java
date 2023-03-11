package Problem1;

import java.util.Random;

public class Wrapper{
    private int size;

    public Wrapper(int size) {
        setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public class FixedRandom implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random rand = new Random();
            char[] arr = new char[size];
            for(int i=0; i<size; i++) {
                arr[i] = (char)(rand.nextInt('Z'-'A')+'A');
            }
            return arr;
        }
    }

    public Cipherable makeFixedRandom() {
        return new FixedRandom();
    }

    public class FixedSelection implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random rand = new Random();
            char[] seq = new char[seed];
            for(int i=0; i<seed; i++) {
                char c = (char)(rand.nextInt('Z'-'A')+'A');
                seq[i] = c;
            }
            char[] arr = new char[size];
            for(int i=0, j=0; i<size; i++) {
                arr[i] = seq[j];
                if(j==seed-1) j=0;
                else j++;
            }
            return arr;
        }
    }

    public Cipherable makeFixedSelection() {
        return new FixedSelection();
    }
}
