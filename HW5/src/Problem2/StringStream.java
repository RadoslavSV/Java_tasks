package Problem2;

import java.util.ArrayList;
import java.util.List;

public class StringStream {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();
        arrList.add("aBc");
        arrList.add("d");
        arrList.add("ef");
        arrList.add("123456");
        System.out.println("Strings before stream manipulation:\n" + arrList);

        List<String> newList = arrList.stream().map(String::toUpperCase).sorted().toList();

        System.out.println("List of strings after stream:\n" + newList);
    }
}
