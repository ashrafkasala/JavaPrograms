package ArrayGeeks;

import java.util.Arrays;

public class ReplaceWithGreatestOnRightHandSide {

    public static void main (String[] args){
        ReplaceWithGreatestOnRightHandSide rep=new ReplaceWithGreatestOnRightHandSide();

        int[] arr = {1,2,17,1,3,2,10};

  rep.replaceWith(arr);
        System.out.println("modified one  " + Arrays.toString(arr));
    }

    void  replaceWith(int[] arr){
        int n=arr.length;
        int max_from_right =arr[n-1];
        arr[n-1]=-1;
        for (int i=n-2;i>=0;i--){

            int temp=arr[i];
            arr[i]=max_from_right;
            if(max_from_right < temp)
            max_from_right=temp;
        }
    }
}
