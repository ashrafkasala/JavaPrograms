package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class customSort {

    /**
     * This class shows how to sort primitive arrays,
     * Wrapper classes Object Arrays
     * @param args
     */
    public static void main(String[] args) {
        //sort primitives array like int array
        int[] intArr = new int[10];
        intArr[0]=1;
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));


        //sorting String array
        String[] strArr = {"A", "C", "B", "Z", "E"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        //sorting String array
        String[] strArr2 = new String[2];
        strArr2[0]="ashraf";
        strArr2[1]="ashif";
        Arrays.sort(strArr2);
        System.out.println(Arrays.toString(strArr2));

        //sorting list of objects of Wrapper classes
        List<String> strList = new ArrayList<String>();
        strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        Collections.sort(strList);
        for(String str: strList) System.out.print(" "+str);
    }
}
