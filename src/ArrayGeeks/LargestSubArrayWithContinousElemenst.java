package ArrayGeeks;

import java.util.HashSet;

/**
 * Created by kaas0616 on 4/6/2018.
 */

/*

difference betw max and min in continous elements is equal to difference betw first and last indexes

* */
public class LargestSubArrayWithContinousElemenst {

    public static void main(String... args){

        int[] a={1,53,51,54,92,93,93,91,92,94,91,95,94,92};

        int max_len=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){

            HashSet<Integer> set = new HashSet<>();
            set.add(a[i]);
            int min=a[i];int max=a[i];

            for(int j=i+1;j<a.length;j++){

                if(set.contains(a[j]))
                    break;
                set.add(a[j]);
                if(a[j]>max)
                    max=a[j];
                if(a[j]<min)
                    min=a[j];

                if((max-min)==(j-i)){
                    if(max_len<(j-i+1))
                        max_len=j-i+1;
                }
            }
        }

        System.out.println("max_len = " + max_len);
    }
}
