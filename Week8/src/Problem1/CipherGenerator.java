package Problem1;

import java.util.HashMap;
import java.util.Map;

public class CipherGenerator {
    public Result countDistinct(Cipherable cipher, int seed) {
        char[] arr = cipher.getSecretChars(seed);

        HashMap<Character,Integer> hmap = new HashMap<>();
        for(char c : arr) {
            hmap.put(c, 0);
        }
        for(char c : arr) {
            hmap.put(c, hmap.get(c) + 1);
        }

        int cnt = 0;
        for(Map.Entry<Character,Integer> e : hmap.entrySet()) {
            if(e.getValue()==1) cnt++;
        }

        return new Result(arr, cnt);
    }
}
