package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LISIterative {
    public static void main(String[] args){
        LISIterative lis=new LISIterative();

        int[] arr={12,4,12,3,4,7,45,76,34};
        System.out.println("LIs length "+Arrays.toString(arr));
        System.out.println("LIs length "+Arrays.toString(lis.findLISLength(arr)));
    }

    int[] findLISLength(int[] arr){
        int[] LIS= new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            LIS[i] = 1;
        }

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<=i-1;j++){
                if(arr[j]<arr[i] && (LIS[j]+1>LIS[i])){
                    LIS[i]=LIS[j]+1;
                }
            }
        }

return LIS;
    }
}
