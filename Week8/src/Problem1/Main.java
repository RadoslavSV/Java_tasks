package Problem1;

public class Main {
    public static void main(String[] args) {
        final int SIZE1 = 6, SIZE2 = 8;
        final int SEED1 = 4, SEED2 = 5;

        Wrapper wr1 = new Wrapper(SIZE1);
        Cipherable cph1 = wr1.makeFixedRandom();
        Result res1 = (new CipherGenerator()).countDistinct(cph1, SEED1);
        System.out.println(res1);

        Wrapper wr2 = new Wrapper(SIZE2);
        Cipherable cph2 = wr2.makeFixedSelection();
        Result res2 = (new CipherGenerator()).countDistinct(cph2, SEED2);
        System.out.println(res2);
    }
}
