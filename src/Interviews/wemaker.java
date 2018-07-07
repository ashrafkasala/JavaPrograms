/*
package Interviews;

import java.util.ArrayList;
import java.util.HashMap;

public class wemaker {
    public static void main(String[] args) {

        int[] a= {1,2,4,1,4};

        HashMap<Integer,Integer> map= new HashMap<>();

        HashMap<Integer,Integer> map2= new HashMap<>();
        ArrayList<String> res= new ArrayList<>();
        for(int i=0;i<a.length;i++)

        for(int i=0;i<a.length;i++){

            if(!map.containsKey(a[i])) {
                int temp=map.get(a[i]);
                temp++;
                map.put(a[i],temp );
            }
            else
                map.put(a[i],1);
        }
int count=0;
        for (HashMap.Entry<Integer,Integer> entry : map.entrySet()){

            if(entry.getValue()==1)
                count++;
        }

        System.out.println("count = " + count);
    }
}
*/
