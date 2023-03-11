import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile
                ("^(((0|1)[0-9]{0,2}|2([0-4]?[0-9]?|5[0-5]?)|[3-9][0-9]?)\\.){3}(((0|1)[0-9]{0,2}|2([0-4]?[0-9]?|5[0-5]?))|[3-9][0-9]?)$");
        Matcher m = p.matcher("255.12.12.034");
        System.out.println(m.find());
    }
}
/*
000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
122.23
Hello.IP
 */