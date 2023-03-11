package Problem3;

import java.util.*;
import java.util.stream.*;

public class Task3 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 101);
        Stream<String> stream1 = intStream.mapToObj(Integer::toString);
        String str = stream1.reduce("", (a, x) -> a + x + "#").replaceAll("#$", "");
        System.out.println(str);

        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<20; i++) {
            int n = rand.nextInt(0, 31);
            list.add(n);
        }

        Stream<Integer> stream2_0 = list.stream(),       // use 5 different Stream<Integer> objects
                stream2_1 = list.stream(),               // because after manipulating the stream, it closes
                stream2_2 = list.stream(),               // and cannot be used again
                stream2_3_1 = list.stream(),             // all five of them are absolutely identical
                stream2_3_2 = list.stream();

        stream2_0.forEach(x -> System.out.printf("%s ", x));
        System.out.println();

        System.out.print("Is there a number in the stream that is divisible by 5? - ");
        if(stream2_1.anyMatch(x -> x%5==0)) System.out.println("YES");
        else System.out.println("NO");

        System.out.print("Are all numbers in the stream less than 15? - ");
        if(stream2_2.anyMatch(x -> x>15)) System.out.println("NO");
        else System.out.println("YES");

        double mean = (double)stream2_3_1.reduce(0, Integer::sum)/20;
        System.out.print("Are numbers in the stream, which are greater than its mean, more than 5? - ");
        long cnt = stream2_3_2.filter(x -> x>mean).count();
        if(cnt > 5) System.out.println("YES");
        else System.out.println("NO");
    }
}
