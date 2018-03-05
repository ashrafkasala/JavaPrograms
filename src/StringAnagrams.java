import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kaas0616 on 2018-03-01.
 */
public class StringAnagrams {
    public static void main(String... aa){
        String s1="ashraf",s2="rafhads";

        char[] s1Temp = s1.toCharArray();
        char[] s2Temp = s2.toCharArray();

        Arrays.sort(s1Temp);
        Arrays.sort(s2Temp);

        if(new String(s1Temp).equals(new String(s2Temp))){

            System.out.print("ANagrams");
        }
        else
            System.out.print("Not Anagrams");


    }
}
