package ArrayGeeks;

import DynamicProgramming.ArrangementsToFormN;

import java.util.Arrays;

public class sortArray012 {

    public static void main(String[] args) {
        int[] a={2,0,1,0,1,2,2,0,1,1,0,2};
        int left=0,right=a.length-1,mid=0;
        //3 way partiononing
        int temp=0;
        while(mid<=right){

            switch (a[mid]){
                case 0:
                     temp=a[mid];
                     a[mid]=a[left];
                     a[left]=temp;
                     left++;
                     mid++;
                     break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp=a[right];
                    a[right]=a[mid];
                    a[mid]=temp;
                    right--;
                    break;
            }
        }

        System.out.println("a +  "+ Arrays.toString(a));
    }
}
