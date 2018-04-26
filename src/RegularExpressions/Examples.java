package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaas0616 on 4/17/2018.
 */
public class Examples {
    public static void main(String[] args) {
        int count = 0;
String exp="abaaaba+  aaba@01b";
        String[] s = {"[abc]", "[^abc]", "[a-z]", "[A-Z]", "[a-zA-Z]", "[0-9]", "[^a-zA-Z0-9]","\\s","\\d","\\w",".","\\S","\\W","a","a+","a*","a?"};

        for (int i = 0; i < s.length; i++) {
            System.out.println("s = " + s[i]);
            System.out.println("exp = " + exp);
            Pattern p = Pattern.compile(s[i]);
            Matcher m = p.matcher(exp);
count=0;
            while (m.find()) {
                count++;
                System.out.println(m.start() + " ------- " + m.end() + " --------- " + m.group());
            }

            System.out.println("count = " + count);
            System.out.println();
        }
    }

}
