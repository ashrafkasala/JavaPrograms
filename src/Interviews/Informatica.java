package Interviews;

import java.util.Arrays;

/**
 * Created by kaas0616 on 5/8/2018.
 */
public class Informatica {
    public static void main(String[] args) {

        int a[]={1,2,3,4,5,6,7};

        for(int n: a){
            System.out.println(n);
            n=n/2;
if(n==2)
    break;
        }
        System.out.println("a = " + Arrays.toString(a));
    }
}
