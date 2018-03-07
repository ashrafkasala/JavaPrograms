package ArrayGeeks;

import java.util.HashSet;
import java.util.Set;

public class firstRepeatingElement {

    public static void main(String... args){

        int[] a={3,4,2,1,2,4,6};
        Set set = new HashSet();
        int min=-1;
        for (int i=a.length-1;i>=0;i--){

            if(set.contains(a[i]))
                min=i;
            else
                set.add(a[i]);
        }

        if(min!=-1)
            System.out.println(" min index at "+min + "  valeu "+a[min]);
        else
            System.out.println("no repetition");
    }
}


