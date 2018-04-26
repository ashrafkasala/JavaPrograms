package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaas0616 on 4/17/2018.
 */
public class Intro {
    public static void main(String[] args) {
        int count=0;
        Pattern p=Pattern.compile("aba");
        Matcher m=p.matcher("abaaabaaabab");

        while(m.find()){
count++;
            System.out.println(m.start()+"-------"+m.end()+"---------"+m.group());
        }

        System.out.println("count = " + count);
    }
}
