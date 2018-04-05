package ArrayGeeks;

import java.util.Arrays;
import java.util.HashMap;

public class ChangeDuplicatestoGetminSum {

    public static void main(String... args){

        int[] a={1,2,3,4,1,1};
        HashMap<Integer,Integer> map= new HashMap<>();
        HashMap<Integer,Integer> res= new HashMap<>();
        Arrays.sort(a);
        int n=a.length;
        for(int i=0;i<n;i++){

            if(map.containsKey(a[i]))
            {
                map.put(a[i],map.get(a[i])+1);
            }
            else
                map.put(a[i],1);
        }

        System.out.println("map = " + map);
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            int value=entry.getValue();
            int key=entry.getKey();
            if(entry.getValue()>1){

                res.put(key,1);
                while(true){

                    if(!map.containsKey(key)){
                        //map.put(key,1);
                        res.put(key,1);
                        //map.put(entry.getKey(),value-1);

                        value--;
                        key++;
                    }
                    else
                        key=key+1;
                    if(value==1)
                        break;
                }
            }
            else
                res.put(key,value);
        }
        System.out.println("map = " + map);
        System.out.println("res = " + res);
int minsum=0;
        for (HashMap.Entry<Integer, Integer> entry : res.entrySet()) {

            minsum+=entry.getKey();
        }
        System.out.println("minsum = " + minsum);
    }
}
